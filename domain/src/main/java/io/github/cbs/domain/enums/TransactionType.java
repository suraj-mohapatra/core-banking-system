package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum TransactionType {

    CASH_DEPOSIT("Cash Deposit"),

    CASH_WITHDRAWAL("Cash Withdrawal"),

    SELF_TRANSFER("Self Transfer"),

    ACCOUNT_TRANSFER("Account Transfer"),

    THIRD_PARTY_TRANSFER("Third Party Transfer"),

    NEFT("NEFT"),

    RTGS("RTGS"),

    IMPS("IMPS"),

    UPI("UPI"),

    CHEQUE_DEPOSIT("Cheque Deposit"),

    CHEQUE_WITHDRAWAL("Cheque Withdrawal"),

    DEMAND_DRAFT_ISSUE("Demand Draft Issue"),

    DEMAND_DRAFT_CANCELLATION("Demand Draft Cancellation"),

    ATM_WITHDRAWAL("ATM Withdrawal"),

    POS_TRANSACTION("POS Transaction"),

    INTERNET_BANKING_TRANSFER("Internet Banking Transfer"),

    MOBILE_BANKING_TRANSFER("Mobile Banking Transfer"),

    INTEREST_CREDIT("Interest Credit"),

    INTEREST_DEBIT("Interest Debit"),

    CHARGES_DEBIT("Charges Debit"),

    PENALTY_DEBIT("Penalty Debit"),

    EMI_DEBIT("EMI Debit"),

    LOAN_DISBURSEMENT("Loan Disbursement"),

    LOAN_REPAYMENT("Loan Repayment"),

    FD_CREATION("Fixed Deposit Creation"),

    FD_CLOSURE("Fixed Deposit Closure"),

    RD_INSTALLMENT("Recurring Deposit Installment"),

    RD_CLOSURE("Recurring Deposit Closure"),

    REVERSAL("Reversal"),

    REFUND("Refund"),

    LIEN_MARKING("Lien Marking"),

    LIEN_REMOVAL("Lien Removal"),

    KYC_UPDATE("KYC Update");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }
}