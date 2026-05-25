package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum BranchStatus {

    ACTIVE("Active"),

    INACTIVE("Inactive"),

    SUSPENDED("Suspended"),

    CLOSED("Closed");

    private final String value;

    BranchStatus(String value) {
        this.value = value;
    }
}