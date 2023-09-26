package com.mbal.saleportal.spring_template.dto.document.request;

import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentNameFilterRequest {

    private String keyword;
    private DocumentCategory documentCategory;
    private PageRequest pageRequest;

    public DocumentNameFilterRequest() {
        this.pageRequest = new PageRequest(10,0);
    }


}
