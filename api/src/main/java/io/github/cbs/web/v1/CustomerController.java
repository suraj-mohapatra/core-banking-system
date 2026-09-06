package io.github.cbs.web.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.ApiResponse;
import io.github.cbs.dto.res.CustomerRes;
import io.github.cbs.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Customers", description = "Customer management APIs")
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "Customer management APIs")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Create a customer")
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerRes>> createCustomer(
            @Valid @RequestBody CustomerReq req) {

        CustomerRes customer = customerService.createCustomer(req);

        ApiResponse<CustomerRes> response
                = ApiResponse.<CustomerRes>builder()
                        .success(true)
                        .message("Customer created successfully")
                        .data(customer)
                        .build();

        return ResponseEntity.ok(response);

    }

    @Operation(summary = "Get a customer by ID")
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
        return null;
    }

    @Operation(summary = "Update a customer")
    @PutMapping("/{customerId}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable Long customerId,
            @Valid @RequestBody CustomerReq req) {
        return null;
    }

    @Operation(summary = "Update customer status")
    @PatchMapping("/{customerId}/status")
    public ResponseEntity<?> updateCustomerStatus(
            @PathVariable Long customerId,
            @RequestParam String status) {
        return null;
    }

    @Operation(summary = "Get all customers")
    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return null;
    }

    @Operation(summary = "Search customers")
    @GetMapping("/search")
    public ResponseEntity<?> searchCustomers(@RequestParam String query) {
        return null;
    }

}
