package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum BranchType {

    RURAL("Rural"),

    SEMI_URBAN("Semi Urban"),

    URBAN("Urban"),

    METRO("Metro");

    private final String value;

    BranchType(String value) {
        this.value = value;
    }
}