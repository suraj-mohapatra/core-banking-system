package io.github.cbs.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerKycRes {

    private Long id;

    private Long customerId;

    private String cifNumber;

    private String kycType;

    private String kycStatus;

    private LocalDateTime submittedAt;

    private String submittedBy;

    private String sourceChannel;

    private Integer documentCount;

    private LocalDateTime verifiedAt;

    private String verifiedBy;

    private String verificationMode;

    private String reviewComments;

    private String rejectionReason;

    private Boolean panVerified;

    private Boolean aadhaarVerified;

    private Boolean addressVerified;

    private String pepCheckStatus;

    private String sanctionCheckStatus;

    private String riskRating;

    private LocalDate expiryDate;

    private Boolean reKycRequired;

    private LocalDate reKycDueDate;

    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
