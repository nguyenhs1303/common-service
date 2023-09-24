package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.Data;

import java.util.List;

@Data
public class FilesRemoveRequest {
    private List<Long> ids;
}
