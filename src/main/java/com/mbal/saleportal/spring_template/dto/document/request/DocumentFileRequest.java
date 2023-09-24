package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DocumentFileRequest {

    @NotNull(message = "fileServiceId invalid")
    private Long fileServiceId;

    @NotNull(message = "fileAwsId invalid")
    private Long fileAwsId;
    private String url;
    private Long size;
    @NotBlank(message = "objectId invalid")
    private String objectId;
    private String bucket;
}
