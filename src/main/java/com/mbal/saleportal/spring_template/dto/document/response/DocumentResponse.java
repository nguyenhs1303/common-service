package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentResponse {

    private Long id;
    private Long nameFormId;
    private String name;
    private LocalDate effectiveDate;
    private LocalDate expirationDate;
    private Boolean status;
    private String notificationStatus;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private List<FileDocumentResponse> files;

}
