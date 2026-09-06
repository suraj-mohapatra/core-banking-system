package io.github.cbs.service;

import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.CustomerKycDocumentRes;
import io.github.cbs.dto.res.CustomerKycRes;

import java.io.InputStream;

public interface CustomerKycService {

    /**
     * Creates a KYC record for the customer, generates a CIF number, and links
     * the CIF to the Customer.
     *
     * @param customerId ID of the existing customer
     * @param request    KYC creation request
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

    /**
     * Uploads and stores a KYC document for the specified customer.
     *
     * @param customerId       ID of the customer
     * @param documentCode     Master document code (e.g., PAN_CARD, AADHAAR_CARD)
     * @param uploadedBy       Maker / employee ID who uploaded the document
     * @param originalFilename Original file name (e.g. pan_card.jpg)
     * @param contentType      MIME type (e.g. image/jpeg, application/pdf)
     * @param fileSize         Size of the file in bytes
     * @param inputStream      Input stream of the file content
     * @return Uploaded document response details
     */
    CustomerKycDocumentRes uploadKycDocument(
            Long customerId,
            String documentCode,
            String uploadedBy,
            String originalFilename,
            String contentType,
            long fileSize,
            InputStream inputStream);
}