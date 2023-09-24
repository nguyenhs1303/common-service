package com.mbal.saleportal.spring_template.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiBaseResponse<T> {

    private String statusCode;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;


}
