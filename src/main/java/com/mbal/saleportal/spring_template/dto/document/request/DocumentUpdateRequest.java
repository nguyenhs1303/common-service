package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUpdateRequest {

    private List<Long> ids;
    private Boolean status;
}
