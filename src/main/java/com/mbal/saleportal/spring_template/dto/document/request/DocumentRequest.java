package com.mbal.saleportal.spring_template.dto.document.request;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.enums.document.DocumentUserType;
import com.mbal.saleportal.spring_template.enums.document.NotificationDocumentStatus;
import com.mbal.saleportal.spring_template.exception.BadRequestException;
import com.mbal.saleportal.spring_template.util.StringUtils;
import liquibase.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest {

    private Long nameDocumentId;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String effectiveDate;  // Chỉ dành cho thông báo nội bộ
    private String expirationDate; // Chỉ dành cho thông báo nội bộ
    private DocumentType type;
    private DocumentUserType userType;
    private SalePortalChannel channel;
    @NotNull(message = "Loại biệu mẫu và thông báo không được được để trống")
    private Long documentSubTypeId;
    private NotificationDocumentStatus notificationStatus;

    @Valid
    private List<DocumentFileRequest> files;

    @JsonSetter("type")
    public void setTypeFromString(String type) {
        try {
            this.type = DocumentType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Vui lòng chọn `FORM` hoặc `NOTIFICATION` cho type");
        }
    }

    @JsonSetter("userType")
    public void setUserTypeFromString(String userType) {
        try {
            this.userType = DocumentUserType.valueOf(userType);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Vui lòng chọn `BUSINESS`, `INDIVIDUAL` hoặc `ALL` cho userType");
        }
    }

    @JsonSetter("channel")
    public void setSalePortalChannelFromString(String channel) {
        try {
            this.channel = SalePortalChannel.valueOf(channel);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Vui lòng chọn `BANCA` hoặc `AGENCY` cho channel");
        }
    }

    @JsonSetter("notificationStatus")
    public void setNotificationDocumentStatusString(String notificationStatus) {
        if (notificationStatus == null) return;
        try {
            this.notificationStatus = NotificationDocumentStatus.valueOf(notificationStatus);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Vui lòng chọn `ACTIVE`, `DE_ACTIVE` hoặc `DELETE` cho notificationStatus");
        }
    }
}


