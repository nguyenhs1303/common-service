package com.mbal.saleportal.spring_template.enums.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentResponseMessage {

    DOCUMENT_NAME_NOT_EXIST("DOCUMENT_NAME_NOT_EXIST", "Tên biểu mẫu và thông báo không tồn tại"),
    SOMETHING_WHEN_WRONG("SOMETHING_WHEN_WRONG", "Có lỗi xảy ra. Vui lòng thử lại.");
    private final String code;
    private final String message;
}
