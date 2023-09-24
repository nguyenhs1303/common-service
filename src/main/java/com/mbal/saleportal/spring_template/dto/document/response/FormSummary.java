package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormSummary {

    private Long count;
    private NameDocumentResponse name;
}
