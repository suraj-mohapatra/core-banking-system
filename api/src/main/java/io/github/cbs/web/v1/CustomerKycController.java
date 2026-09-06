package io.github.cbs.web.v1;

import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.ApiResponse;
import io.github.cbs.dto.res.CustomerKycDocumentRes;
import io.github.cbs.dto.res.CustomerKycRes;
import io.github.cbs.service.CustomerKycService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/customer-kyc")
@RequiredArgsConstructor
@Tag(name = "Customer KYC", description = "Customer KYC management APIs")
public class CustomerKycController {

    private final CustomerKycService customerKycService;

    @Operation(summary = "Create customer KYC and generate CIF")
    @PostMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerKycRes>> createCustomerKyc(
            @PathVariable Long customerId,
            @Valid @RequestBody CustomerKycReq req) {
        CustomerKycRes response = customerKycService.createCustomerKyc(customerId, req);
        ApiResponse<CustomerKycRes> apiResponse = ApiResponse.<CustomerKycRes>builder()
                .success(true)
                .message("Customer KYC created and CIF number generated successfully")
                .data(response)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @Operation(summary = "Get customer KYC")
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerKycRes>> getCustomerKyc(@PathVariable Long customerId) {
        CustomerKycRes response = customerKycService.getCustomerKyc(customerId);
        ApiResponse<CustomerKycRes> apiResponse = ApiResponse.<CustomerKycRes>builder()
                .success(true)
                .message("Customer KYC retrieved successfully")
                .data(response)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @Operation(summary = "Update customer KYC")
    @PutMapping("/{customerId}")
    public Object updateCustomerKyc(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Verify customer KYC")
    @PostMapping("/{customerId}/verify")
    public Object verifyCustomerKyc(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Reject customer KYC")
    @PostMapping("/{customerId}/reject")
    public Object rejectCustomerKyc(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Delete a customer KYC document")
    @DeleteMapping("/{customerId}/documents/{documentId}")
    public Object deleteKycDocument(
            @PathVariable Long customerId,
            @PathVariable Long documentId) {
        return null;
    }

    @Operation(summary = "Upload a customer KYC document")
    @PostMapping(value = "/{customerId}/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<CustomerKycDocumentRes>> uploadKycDocument(
            @PathVariable Long customerId,
            @RequestParam("documentCode") String documentCode,
            @RequestParam("uploadedBy") String uploadedBy,
            @RequestParam("file") MultipartFile file) throws IOException {

        CustomerKycDocumentRes response = customerKycService.uploadKycDocument(
                customerId,
                documentCode,
                uploadedBy,
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize(),
                file.getInputStream()
        );

        ApiResponse<CustomerKycDocumentRes> apiResponse = ApiResponse.<CustomerKycDocumentRes>builder()
                .success(true)
                .message("KYC document uploaded successfully")
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
