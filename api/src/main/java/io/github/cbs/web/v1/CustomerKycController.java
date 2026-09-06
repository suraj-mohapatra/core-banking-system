package io.github.cbs.web.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/customer-kyc")
@Tag(name = "Customer KYC", description = "Customer KYC management APIs")
public class CustomerKycController {

    @Operation(summary = "Create customer KYC")
    @PostMapping("/{customerId}")
    public Object createCustomerKyc(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Get customer KYC")
    @GetMapping("/{customerId}")
    public Object getCustomerKyc(@PathVariable Long customerId) {
        return null;
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

    @Operation(summary = "Upload a customer KYC document")
    @PostMapping("/{customerId}/documents")
    public Object uploadKycDocument(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Delete a customer KYC document")
    @DeleteMapping("/{customerId}/documents/{documentId}")
    public Object deleteKycDocument(
            @PathVariable Long customerId,
            @PathVariable Long documentId) {
        return null;
    }
}


// method signatures are gonna change. these are dummies as of now
