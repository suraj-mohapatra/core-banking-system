package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum AccountType {

    SAVINGS("Savings"),

    CURRENT("Current"),

    SALARY("Salary"),

    FIXED_DEPOSIT("Fixed Deposit"),

    RECURRING_DEPOSIT("Recurring Deposit"),

    NRE("Non Resident External"),

    NRO("Non Resident Ordinary"),

    FCNR("Foreign Currency Non Resident"),

    DEMAT("Demat"),

    LOAN("Loan"),

    CASH_CREDIT("Cash Credit"),

    OVERDRAFT("Overdraft"),

    PENSION("Pension"),

    STUDENT("Student"),

    MINOR("Minor"),

    JOINT("Joint"),

    ESCROW("Escrow"),

    CORPORATE("Corporate");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }
}