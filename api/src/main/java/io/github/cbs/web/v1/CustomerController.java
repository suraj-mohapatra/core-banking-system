package io.github.cbs.web.v1;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.ApiResponse;
import io.github.cbs.dto.res.CustomerRes;
import io.github.cbs.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerRes>> createCustomer(
            @Valid @RequestBody CustomerReq req) {

        CustomerRes customer = customerService.createCustomer(req);

        ApiResponse<CustomerRes> response =
                ApiResponse.<CustomerRes>builder()
                        .success(true)
                        .message("Customer created successfully")
                        .data(customer)
                        .build();

        return ResponseEntity.ok(response);

    }

}