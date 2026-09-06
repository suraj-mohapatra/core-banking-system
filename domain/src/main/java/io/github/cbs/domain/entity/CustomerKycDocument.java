package io.github.cbs.domain.entity;

import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a document submitted as part of a customer's KYC verification.
 */
@Entity
@Table(name = "customer_kyc_document", schema = "core")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class CustomerKycDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_kyc_id", nullable = false)
    private CustomerKyc customerKyc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_master_id", nullable = false)
    private KycDocumentMaster documentMaster;

    @Column(name = "document_code", nullable = false, length = 50)
    private String documentCode;

    @Column(name = "document_type", nullable = false, length = 20)
    private String documentType; // POI / POA / PHOTO / SIGNATURE etc.

    @Column(name = "document_name", nullable = false, length = 200)
    private String documentName;

    @Column(name = "file_name", nullable = false, length = 200)
    private String fileName;

    @Column(name = "file_path", length = 500)
    private String filePath;

    @Column(name = "file_url", length = 500)
    private String fileUrl;

    @Column(name = "mime_type", length = 100)
    private String mimeType;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "uploaded_at")
    private java.time.LocalDateTime uploadedAt;

    @Column(name = "uploaded_by", length = 100)
    private String uploadedBy;

    @Column(name = "verification_status", nullable = false, length = 30)
    private String verificationStatus; // PENDING, VERIFIED, REJECTED, EXPIRED

    @Column(name = "verified_by", length = 100)
    private String verifiedBy;

    @Column(name = "verified_at")
    private java.time.LocalDateTime verifiedAt;

    @Column(name = "reject_reason", length = 1000)
    private String rejectReason;

    @Column(name = "expiry_date")
    private java.time.LocalDate expiryDate;

    @Column(name = "is_mandatory")
    private Boolean isMandatory = false;

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
        if (uploadedAt == null) {
            uploadedAt = java.time.LocalDateTime.now();
        }
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
        CustomerKycDocument that = (CustomerKycDocument) object;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
