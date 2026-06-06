package io.github.cbs.domain.entity;

import io.github.cbs.domain.enums.BranchStatus;
import io.github.cbs.domain.enums.BranchType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "branch_master", schema = "core")
@Data
public class BranchMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_code", unique = true, nullable = false, length = 10)
    private String branchCode;

    @Column(name = "branch_name", nullable = false, length = 100)
    private String branchName;

    @Column(name = "ifsc_code", unique = true, nullable = false, length = 11)
    private String ifscCode;

    @Column(name = "micr_code", length = 9)
    private String micrCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "branch_type", nullable = false, length = 20)
    private BranchType branchType; // e.g., RURAL, SEMI-URBAN, URBAN, METRO

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email_id", length = 100)
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BranchStatus status;

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