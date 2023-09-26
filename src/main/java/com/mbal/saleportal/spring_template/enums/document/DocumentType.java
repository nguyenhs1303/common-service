package com.mbal.saleportal.spring_template.enums.document;

import com.mbal.saleportal.spring_template.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentType {

    FORM, // bieu mau
    NOTIFICATION, // thong bao
    ALL; // Dành cho tat ca

    public static void checkDocumentType(String s) {
        try {
            DocumentType.valueOf(s);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(DocumentResponseMessage.DOCUMENT_TYPE_INVALID);
        }
    }

    public static DocumentType convertFromString(String s) {
        try {

            return DocumentType.valueOf(s);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
