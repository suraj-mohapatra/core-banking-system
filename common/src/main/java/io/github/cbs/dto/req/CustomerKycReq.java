package io.github.cbs.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerKycReq {

    @NotBlank(message = "KYC type is required")
    @Size(max = 30)
    private String kycType;

    @NotBlank(message = "Source channel is required")
    @Size(max = 50)
    private String sourceChannel;

    @NotBlank(message = "Submitted by is required")
    @Size(max = 100)
    private String submittedBy;

    private Boolean panVerified = false;

    private Boolean aadhaarVerified = false;

    private Boolean addressVerified = false;

    @Size(max = 30)
    private String pepCheckStatus = "CLEARED";

    @Size(max = 30)
    private String sanctionCheckStatus = "CLEARED";

    @NotBlank(message = "Risk rating is required")
    @Size(max = 20)
    private String riskRating;

    @Size(max = 1000)
    private String reviewComments;
}
