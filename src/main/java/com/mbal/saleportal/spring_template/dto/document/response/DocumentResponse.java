package com.mbal.saleportal.spring_template.dto.document.response;

import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.enums.document.DocumentUserType;
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
    private Long documentNameId;
    private String name;
    private LocalDate effectiveDate;
    private LocalDate expirationDate;
    private Boolean uploadStatus;
    private DocumentNotificationStatus notificationStatus;
    private DocumentType type;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private DocumentCategory documentCategory;
    private SalePortalChannel channel;
    private DocumentUserType userType;
    private List<DocumentFileResponse> files;
}
