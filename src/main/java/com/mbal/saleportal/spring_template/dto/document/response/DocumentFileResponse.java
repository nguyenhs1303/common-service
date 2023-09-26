package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentFileResponse {

    private Long id;
    private Long documentId;
    private Long fileId;
    private Long fileAwsId;
    private String url;
    private Long size;
    private String objectId;
    private String bucket;
}
