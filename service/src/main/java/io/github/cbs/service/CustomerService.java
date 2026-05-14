package io.github.cbs.service;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;

public interface CustomerService {

    CustomerRes createCustomer(CustomerReq request);

}
