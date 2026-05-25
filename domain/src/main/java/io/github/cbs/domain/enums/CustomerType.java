package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum CustomerType {

    INDIVIDUAL("Individual"),

    JOINT("Joint"),

    MINOR("Minor"),

    SENIOR_CITIZEN("Senior Citizen"),

    STUDENT("Student"),

    SALARIED("Salaried"),

    SELF_EMPLOYED("Self Employed"),

    HUF("Hindu Undivided Family"),

    SOLE_PROPRIETORSHIP("Sole Proprietorship"),

    PARTNERSHIP("Partnership"),

    LLP("Limited Liability Partnership"),

    PRIVATE_LIMITED_COMPANY("Private Limited Company"),

    PUBLIC_LIMITED_COMPANY("Public Limited Company"),

    TRUST("Trust"),

    SOCIETY("Society"),

    NGO("Non Government Organization"),

    GOVERNMENT("Government"),

    PSU("Public Sector Undertaking"),

    FOREIGN_ENTITY("Foreign Entity"),

    NRI("Non Resident Indian");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }
}