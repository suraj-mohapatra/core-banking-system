package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeStatus {

    ACTIVE("Active"),

    INACTIVE("Inactive"),

    ON_PROBATION("On Probation"),

    CONFIRMED("Confirmed"),

    SUSPENDED("Suspended"),

    TERMINATED("Terminated"),

    RESIGNED("Resigned"),

    RETIRED("Retired"),

    TRANSFERRED("Transferred"),

    ON_LEAVE("On Leave"),

    DEPUTED("Deputed"),

    LOCKED("Locked"),

    UNDER_INVESTIGATION("Under Investigation");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }
}