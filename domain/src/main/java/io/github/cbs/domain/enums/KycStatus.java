package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum KycStatus {

    NOT_SUBMITTED("Not Submitted"),

    PENDING("Pending"),

    UNDER_VERIFICATION("Under Verification"),

    VERIFIED("Verified"),

    REJECTED("Rejected"),

    EXPIRED("Expired"),

    REKYC_REQUIRED("Re-KYC Required"),

    PARTIALLY_COMPLETED("Partially Completed"),

    ON_HOLD("On Hold"),

    SUSPENDED("Suspended"),

    DIGITALLY_VERIFIED("Digitally Verified"),

    MANUALLY_VERIFIED("Manually Verified");

    private final String value;

    KycStatus(String value) {
        this.value = value;
    }
}