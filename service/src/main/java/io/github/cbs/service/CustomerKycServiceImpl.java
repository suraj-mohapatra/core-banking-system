package io.github.cbs.service;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.domain.entity.CustomerKyc;
import io.github.cbs.domain.entity.CustomerKycDocument;
import io.github.cbs.domain.entity.KycDocumentMaster;
import io.github.cbs.domain.repository.CustomerKycDocumentRepository;
import io.github.cbs.domain.repository.CustomerKycRepository;
import io.github.cbs.domain.repository.CustomerRepository;
import io.github.cbs.domain.repository.KycDocumentMasterRepository;
import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.CustomerKycDocumentRes;
import io.github.cbs.dto.res.CustomerKycRes;
import io.github.cbs.exception.BusinessException;
import io.github.cbs.service.mapper.CustomerKycMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerKycServiceImpl implements CustomerKycService {

    private final CustomerRepository customerRepository;
    private final CustomerKycRepository customerKycRepository;
    private final CustomerKycDocumentRepository customerKycDocumentRepository;
    private final KycDocumentMasterRepository kycDocumentMasterRepository;
    private final CustomerKycMapper customerKycMapper;
    private final CifGeneratorService cifGeneratorService;

    private static final String UPLOAD_DIR = "uploads/kyc";

    @Override
    public CustomerKycRes createCustomerKyc(Long customerId, CustomerKycReq request) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new BusinessException("Customer with ID " + customerId + " not found"));

        if (customerKycRepository.existsByCustomerId(customerId)) {
            throw new BusinessException("KYC record already exists for customer ID " + customerId);
        }

        // Generate CIF Number if customer doesn't already have one
        String cifNumber = customer.getCifNumber();
        if (cifNumber == null || cifNumber.isBlank()) {
            cifNumber = cifGeneratorService.generateUniqueCifNumber();
            customer.setCifNumber(cifNumber);
            customerRepository.save(customer);
            log.info("Assigned new CIF number {} to customer ID {}", cifNumber, customerId);
        }

        CustomerKyc kyc = customerKycMapper.toEntity(request);
        kyc.setCustomerId(customerId);
        kyc.setSubmittedAt(LocalDateTime.now());
        kyc.setIsActive(true);

        boolean isFullyVerified = Boolean.TRUE.equals(request.getPanVerified()) && (Boolean.TRUE.equals(request.getAadhaarVerified()) || Boolean.TRUE.equals(request.getAddressVerified()));

        if (isFullyVerified) {
            kyc.setKycStatus("VERIFIED");
            kyc.setVerifiedAt(LocalDateTime.now());
            kyc.setVerifiedBy(request.getSubmittedBy());
            kyc.setVerificationMode("DIGITAL");
            kyc.setExpiryDate(LocalDate.now().plusYears(10));
        } else {
            kyc.setKycStatus("PENDING_VERIFICATION");
        }

        CustomerKyc savedKyc = customerKycRepository.save(kyc);
        log.info("Created KYC record ID {} for customer ID {} with status {}", savedKyc.getId(), customerId, savedKyc.getKycStatus());

        CustomerKycRes response = customerKycMapper.toResponse(savedKyc);
        response.setCifNumber(cifNumber);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerKycRes getCustomerKyc(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new BusinessException("Customer with ID " + customerId + " not found"));

        CustomerKyc kyc = customerKycRepository.findByCustomerId(customerId).orElseThrow(() -> new BusinessException("KYC record not found for customer ID " + customerId));

        CustomerKycRes response = customerKycMapper.toResponse(kyc);
        response.setCifNumber(customer.getCifNumber());
        return response;
    }

    @Override
    public CustomerKycDocumentRes uploadKycDocument(Long customerId, String documentCode, String uploadedBy, String originalFilename, String contentType, long fileSize, InputStream inputStream) {

        if (fileSize <= 0) {
            throw new BusinessException("Uploaded file cannot be empty");
        }

        CustomerKyc kyc = customerKycRepository.findByCustomerId(customerId).orElseThrow(() -> new BusinessException("KYC record not found for customer ID " + customerId + ". Please create KYC first."));

        KycDocumentMaster master = kycDocumentMasterRepository.findByDocumentCode(documentCode).orElseThrow(() -> new BusinessException("Invalid document code: " + documentCode));

        // Validate max file size
        if (master.getMaxFileSize() != null && fileSize > master.getMaxFileSize()) {
            throw new BusinessException("File size exceeds maximum allowed size of " + master.getMaxFileSize() + " bytes");
        }

        // Validate file format
        String safeFilename = originalFilename != null ? originalFilename : "document";
        String fileExtension = getFileExtension(safeFilename).toUpperCase();
        if (master.getAllowedFileFormats() != null && !master.getAllowedFileFormats().toUpperCase().contains(fileExtension)) {
            throw new BusinessException("File format '" + fileExtension + "' not allowed. Allowed formats: " + master.getAllowedFileFormats());
        }

        // Save file locally to uploads/kyc/{customerId}/
        String storedFileName = UUID.randomUUID() + "_" + safeFilename;
        Path targetDir = Paths.get(UPLOAD_DIR, String.valueOf(customerId));
        Path targetPath = targetDir.resolve(storedFileName);

        try {
            Files.createDirectories(targetDir);
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Failed to store uploaded KYC file", e);
            throw new BusinessException("Failed to store file: " + e.getMessage());
        }

        // Persist CustomerKycDocument entity
        CustomerKycDocument doc = new CustomerKycDocument();
        doc.setCustomerKyc(kyc);
        doc.setDocumentMaster(master);
        doc.setDocumentCode(master.getDocumentCode());
        doc.setDocumentType(master.getDocumentType());
        doc.setDocumentName(master.getName());
        doc.setFileName(safeFilename);
        doc.setFilePath(targetPath.toString());
        doc.setFileUrl("/files/kyc/" + customerId + "/" + storedFileName);
        doc.setMimeType(contentType);
        doc.setFileSize(fileSize);
        doc.setUploadedBy(uploadedBy);
        doc.setUploadedAt(LocalDateTime.now());
        doc.setVerificationStatus("PENDING");
        doc.setIsMandatory(master.getIsMandatory());
        doc.setIsActive(true);

        CustomerKycDocument savedDoc = customerKycDocumentRepository.save(doc);

        // Update document count on parent KYC record
        kyc.setDocumentCount((kyc.getDocumentCount() == null ? 0 : kyc.getDocumentCount()) + 1);
        customerKycRepository.save(kyc);

        return CustomerKycDocumentRes.builder().id(savedDoc.getId()).documentCode(savedDoc.getDocumentCode()).documentType(savedDoc.getDocumentType()).documentName(savedDoc.getDocumentName()).fileName(savedDoc.getFileName()).fileUrl(savedDoc.getFileUrl()).mimeType(savedDoc.getMimeType()).fileSize(savedDoc.getFileSize()).uploadedBy(savedDoc.getUploadedBy()).uploadedAt(savedDoc.getUploadedAt()).verificationStatus(savedDoc.getVerificationStatus()).build();
    }

    private String getFileExtension(String filename) {
        int lastIndex = filename.lastIndexOf('.');
        return lastIndex == -1 ? "" : filename.substring(lastIndex + 1);
    }
}