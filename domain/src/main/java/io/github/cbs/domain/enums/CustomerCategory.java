package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum CustomerCategory {

    REGULAR("Regular"),

    PREMIUM("Premium"),

    VIP("VIP"),

    HIGH_NET_WORTH("High Net Worth"),

    CORPORATE("Corporate"),

    SME("Small and Medium Enterprise"),

    GOVERNMENT("Government"),

    STAFF("Staff"),

    SENIOR_CITIZEN("Senior Citizen"),

    STUDENT("Student"),

    MINOR("Minor"),

    NRI("Non Resident Indian"),

    AGRICULTURE("Agriculture"),

    PRIORITY_SECTOR("Priority Sector");

    private final String value;

    CustomerCategory(String value) {
        this.value = value;
    }
}