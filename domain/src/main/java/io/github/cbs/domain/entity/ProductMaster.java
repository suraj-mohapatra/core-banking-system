package io.github.cbs.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity representing the Product Master.
 * Defines the parameters for different banking products (Savings, Current, Loans).
 */
@Entity
@Table(name = "product_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", unique = true, nullable = false, length = 20)
    private String productCode; // e.g., SB-101, LA-505

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName; // e.g., Senior Citizen Savings, Gold Loan

    @Column(name = "product_type", nullable = false, length = 20)
    private String productType; // e.g., SAVINGS, CURRENT, LOAN, FIXED_DEPOSIT

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate; // Standard ROI for the product

    @Column(name = "min_balance_requirement", precision = 20, scale = 2)
    private BigDecimal minBalanceRequirement;

    @Column(name = "is_checkbook_allowed")
    private Boolean isCheckbookAllowed = false;

    @Column(name = "is_debit_card_allowed")
    private Boolean isDebitCardAllowed = false;

    @Column(name = "min_tenure_months")
    private Integer minTenureMonths; // Relevant for Loans/FDs

    @Column(name = "max_tenure_months")
    private Integer maxTenureMonths;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}