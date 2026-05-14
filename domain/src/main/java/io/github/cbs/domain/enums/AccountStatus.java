package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum AccountStatus {

    PENDING_APPROVAL("Pending Approval"),

    ACTIVE("Active"),

    DORMANT("Dormant"),

    INACTIVE("Inactive"),

    FROZEN("Frozen"),

    DEBIT_FREEZE("Debit Freeze"),

    CREDIT_FREEZE("Credit Freeze"),

    LIEN_MARKED("Lien Marked"),

    SUSPENDED("Suspended"),

    CLOSED("Closed"),

    BLOCKED("Blocked"),

    UNDER_VERIFICATION("Under Verification"),

    KYC_PENDING("KYC Pending"),

    KYC_EXPIRED("KYC Expired"),

    DECEASED("Deceased"),

    WRITTEN_OFF("Written Off");

    private final String value;

    AccountStatus(String value) {
        this.value = value;
    }
}