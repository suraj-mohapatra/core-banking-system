package io.github.cbs.service;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.domain.entity.CustomerKyc;
import io.github.cbs.domain.repository.CustomerKycRepository;
import io.github.cbs.domain.repository.CustomerRepository;
import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.CustomerKycRes;
import io.github.cbs.exception.BusinessException;
import io.github.cbs.service.mapper.CustomerKycMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerKycServiceImpl implements CustomerKycService {

    private final CustomerRepository customerRepository;
    private final CustomerKycRepository customerKycRepository;
    private final CustomerKycMapper customerKycMapper;
    private final CifGeneratorService cifGeneratorService;

    @Override
    public CustomerKycRes createCustomerKyc(Long customerId, CustomerKycReq request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Customer with ID " + customerId + " not found"));

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

        boolean isFullyVerified = Boolean.TRUE.equals(request.getPanVerified())
                && (Boolean.TRUE.equals(request.getAadhaarVerified()) || Boolean.TRUE.equals(request.getAddressVerified()));

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
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Customer with ID " + customerId + " not found"));

        CustomerKyc kyc = customerKycRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new BusinessException("KYC record not found for customer ID " + customerId));

        CustomerKycRes response = customerKycMapper.toResponse(kyc);
        response.setCifNumber(customer.getCifNumber());
        return response;
    }
}
