package io.github.cbs.service;

import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.CustomerKycRes;

public interface CustomerKycService {

    /**
     * Creates a KYC record for the customer, generates a CIF number, and links
     * the CIF to the Customer.
     *
     * @param customerId ID of the existing customer
     * @param request KYC creation request
     * @return KYC response containing the assigned CIF number
     */
    CustomerKycRes createCustomerKyc(Long customerId, CustomerKycReq request);

    /**
     * Retrieves the KYC record for the customer.
     *
     * @param customerId ID of the customer
     * @return KYC response containing verification and risk details
     */
    CustomerKycRes getCustomerKyc(Long customerId);
}
