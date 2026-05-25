package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeDesignation {

    CLERK("Clerk"),

    TELLER("Teller"),

    CASHIER("Cashier"),

    SINGLE_WINDOW_OPERATOR("Single Window Operator"),

    PROBATIONARY_OFFICER("Probationary Officer"),

    ASSISTANT_MANAGER("Assistant Manager"),

    DEPUTY_MANAGER("Deputy Manager"),

    MANAGER("Manager"),

    SENIOR_MANAGER("Senior Manager"),

    CHIEF_MANAGER("Chief Manager"),

    ASSISTANT_GENERAL_MANAGER("Assistant General Manager"),

    DEPUTY_GENERAL_MANAGER("Deputy General Manager"),

    GENERAL_MANAGER("General Manager"),

    BRANCH_MANAGER("Branch Manager"),

    OPERATIONS_MANAGER("Operations Manager"),

    CREDIT_OFFICER("Credit Officer"),

    RELATIONSHIP_MANAGER("Relationship Manager"),

    COMPLIANCE_OFFICER("Compliance Officer"),

    AUDITOR("Auditor"),

    REGIONAL_MANAGER("Regional Manager"),

    ZONAL_MANAGER("Zonal Manager");

    private final String value;

    EmployeeDesignation(String value) {
        this.value = value;
    }
}