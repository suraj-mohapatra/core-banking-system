package io.github.cbs.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a customer's KYC record, verification status, and risk details.
 */
@Entity
@Table(name = "customer_kyc", schema = "core")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class CustomerKyc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false, unique = true)
    private Long customerId;

    @OneToMany(mappedBy = "customerKyc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerKycDocument> documents = new ArrayList<>();

    @Column(name = "kyc_type", nullable = false, length = 30)
    private String kycType;

    @Column(name = "kyc_status", nullable = false, length = 30)
    private String kycStatus;

    @Column(name = "submitted_at")
    private java.time.LocalDateTime submittedAt;

    @Column(name = "submitted_by", length = 100)
    private String submittedBy;

    @Column(name = "source_channel", length = 50)
    private String sourceChannel;

    @Column(name = "document_count")
    private Integer documentCount = 0;

    @Column(name = "verified_at")
    private java.time.LocalDateTime verifiedAt;

    @Column(name = "verified_by", length = 100)
    private String verifiedBy;

    @Column(name = "verification_mode", length = 50)
    private String verificationMode;

    @Column(name = "review_comments", length = 1000)
    private String reviewComments;

    @Column(name = "rejection_reason", length = 1000)
    private String rejectionReason;

    @Column(name = "pan_verified")
    private Boolean panVerified = false;

    @Column(name = "aadhaar_verified")
    private Boolean aadhaarVerified = false;

    @Column(name = "address_verified")
    private Boolean addressVerified = false;

    @Column(name = "pep_check_status", length = 30)
    private String pepCheckStatus;

    @Column(name = "sanction_check_status", length = 30)
    private String sanctionCheckStatus;

    @Column(name = "risk_rating", length = 20)
    private String riskRating;

    @Column(name = "expiry_date")
    private java.time.LocalDate expiryDate;

    @Column(name = "re_kyc_required")
    private Boolean reKycRequired = false;

    @Column(name = "re_kyc_due_date")
    private java.time.LocalDate reKycDueDate;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = java.time.LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        Class<?> oEffectiveClass = object instanceof HibernateProxy ? ((HibernateProxy) object).getHibernateLazyInitializer().getPersistentClass() : object.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {
            return false;
        }
        CustomerKyc that = (CustomerKyc) object;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
