package io.github.cbs.service;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;

import java.util.List;

public interface CustomerService {

    CustomerRes createCustomer(CustomerReq request);

    CustomerRes updateCustomer(Long customerId, CustomerReq request);

    CustomerRes getCustomerById(Long customerId);

    List<CustomerRes> searchCustomers(CustomerReq request);

    void deactivateCustomer(Long customerId);

}