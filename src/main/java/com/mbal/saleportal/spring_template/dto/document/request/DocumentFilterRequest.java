package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class DocumentFilterRequest {

    private String keyword;
    // trạng thái
    private Boolean uploadStatus;
    //ngày đăng tải
    private String startCreatedAt;
    private String endCreatedAt;
    //chỉnh sửa lần cuối
    private String startUpdateAt;
    private String endUpdateAt;


    private String documentType;
    private String documentCategory;
    private String notificationStatus;
    private PageRequest pageRequest;

    public DocumentFilterRequest() {
        this.pageRequest = new PageRequest(10, 0);
    }
}
