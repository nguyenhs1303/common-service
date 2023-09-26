package com.mbal.saleportal.spring_template.enums.document;

import com.mbal.saleportal.spring_template.exception.BadRequestException;

public enum DocumentUserType {

    BUSINESS, // Doanh nghiep
    INDIVIDUAL, // Ca nhan
    ALL // tat ca
    ;

    public static void checkUserType(String userType) {
        try {
            valueOf(userType);
        }catch (Exception e){
            throw new BadRequestException(DocumentResponseMessage.DOCUMENT_USER_TYPE_INVALID);
        }
    }
}
