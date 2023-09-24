package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDocumentRequest {

    private String keyword;
    // trạng thái
    private String status;
    //ngày đăng tải
    private String startCreatedAt;
    private String endCreatedAt;
    //chỉnh sửa lần cuối
    private String startUpdateAt;
    private String endUpdateAt;

    private Integer size = 10;
    private Integer page = 0;
}
