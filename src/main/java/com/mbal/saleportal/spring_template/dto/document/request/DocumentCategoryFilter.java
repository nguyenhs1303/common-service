package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DocumentCategoryFilter {

    private String type;
    private PageRequest pageRequest;

    public DocumentCategoryFilter() {
        this.pageRequest = new PageRequest(10,0);
    }
}
