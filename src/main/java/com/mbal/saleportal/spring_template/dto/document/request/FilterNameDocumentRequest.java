package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FilterNameDocumentRequest {

    private String keyword;
    private PageRequest pageRequest;

    public FilterNameDocumentRequest() {
        this.pageRequest = new PageRequest(0,10);
    }


}
