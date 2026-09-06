package io.github.cbs.web.v1;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.ApiResponse;
import io.github.cbs.dto.res.CustomerRes;
import io.github.cbs.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

@Tag(name = "Customers", description = "Customer management APIs")
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Create a customer")
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerRes>> createCustomer(
            @Valid @RequestBody CustomerReq req) {

        CustomerRes customer = customerService.createCustomer(req);

        ApiResponse<CustomerRes> response = ApiResponse.<CustomerRes>builder()
                .success(true)
                .message("Customer created successfully")
                .data(customer)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get a customer by ID")
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerRes>> getCustomer(@PathVariable Long customerId) {
        CustomerRes customer = customerService.getCustomerById(customerId);

        ApiResponse<CustomerRes> response = ApiResponse.<CustomerRes>builder()
                .success(true)
                .message("Customer retrieved successfully")
                .data(customer)
                .build();

        return ResponseEntity.ok(response);
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
