package io.github.cbs.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerKycDocumentRes {

    private Long id;
    private String documentCode;
    private String documentType;
    private String documentName;
    private String fileName;
    private String fileUrl;
    private String mimeType;
    private Long fileSize;
    private String uploadedBy;
    private LocalDateTime uploadedAt;
    private String verificationStatus;
}