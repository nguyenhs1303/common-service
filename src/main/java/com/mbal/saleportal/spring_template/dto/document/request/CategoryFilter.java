package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class CategoryFilter {

    private String type;
    private PageRequest pageRequest;

    public CategoryFilter() {
        this.pageRequest = new PageRequest(0,10);
    }
}
