package com.mbal.saleportal.spring_template.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiBaseResponseError {

    private String errorCode;
    private String messages;
}
