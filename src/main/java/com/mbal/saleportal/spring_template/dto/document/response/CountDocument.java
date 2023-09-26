package com.mbal.saleportal.spring_template.dto.document.response;

import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountDocument {

    private Long count;
    private DocumentCategory name;
    private String vietnameseName;

    public CountDocument(Long count, DocumentCategory name) {
        this.count = count;
        this.name = name;
        this.vietnameseName = name.getVietnameseName();
    }
}
