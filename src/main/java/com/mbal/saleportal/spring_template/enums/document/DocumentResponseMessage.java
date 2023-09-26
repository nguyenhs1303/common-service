package com.mbal.saleportal.spring_template.enums.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentResponseMessage {

    DOCUMENT_NAME_NOT_EXIST("DOCUMENT_NAME_NOT_EXIST", "Tên biểu mẫu (form) không tồn tại"),
    DOCUMENT_CATEGORY_NOT_BELONG_TO_FORM("DOCUMENT_CATEGORY_NOT_BELONG_TO_FORM", "Danh mục (DocumentCategory ) không thuộc `Biểu mẫu` (FORM)"),
    DOCUMENT_NAME_NOT_BELONG_TO_DOCUMENT_CATEGORY("DOCUMENT_NAME_NOT_BELONG_TO_DOCUMENT_CATEGORY", "`Tên` (NameDocument) không thuộc `Danh mục` (CategoryDocument)"),
    DOCUMENT_CATEGORY_NOT_BELONG_TO_NOTIFICATION("DOCUMENT_CATEGORY_NOT_BELONG_TO_NOTIFICATION", "Danh mục (DocumentCategory ) không thuộc `Thông báo` (NOTIFICATION)"),
    SALE_PORTAL_CHANNEL_INVALID("SALE_PORTAL_CHANNEL_INVALID", "Vui lòng chọn `BANCA`, `AGENCY` hoặc `ALL` cho `channel`"),
    DOCUMENT_TYPE_INVALID("DOCUMENT_TYPE_INVALID", "Vui lòng chọn `FORM` hoặc `NOTIFICATION` cho `type`"),
    DOCUMENT_CATEGORY_INVALID("DOCUMENT_CATEGORY_INVALID", "Vui lòng kiểm tra lại thông tin (documentCategory)"),
    DOCUMENT_USER_TYPE_INVALID("DOCUMENT_USER_TYPE_INVALID", "Vui lòng chọn `BUSINESS`, `INDIVIDUAL` hoặc `ALL` cho `userType`"),
    EFFECTIVE_DATE_NOT_AFTER_NOW("EFFECTIVE_DATE_NOT_AFTER_NOW", "`Ngày hiệu lực` (effectiveDate) không được lớn hơn ngày hiện tại"),
    DATE_FORMAT("DATE_FORMAT", "Định dạng ngày tháng năm hợp lệ là DD/MM/YYYY (26/09/2023)"),
    EFFECTIVE_DATE_NOT_AFTER_EXPIRATION_DATE("EFFECTIVE_DATE_NOT_AFTER_EXPIRATION_DATE", "`Ngày hiệu lực` (effectiveDate) không được lớn hơn `Ngày hết hiệu lực` (expirationDate)"),
    SOMETHING_WHEN_WRONG("SOMETHING_WHEN_WRONG", "Có lỗi xảy ra. Vui lòng thử lại.");
    private final String code;
    private final String message;
}
