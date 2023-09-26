package com.mbal.saleportal.spring_template.dto.document.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest {

    private Long documentNameId;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String effectiveDate;  // Chỉ dành cho thông báo nội bộ
    private String expirationDate; // Chỉ dành cho thông báo nội bộ
    private String type;
    private String userType;
    private String channel;
    private String documentCategory;

    @Valid
    private List<DocumentFileRequest> files;

}


