package com.mbal.saleportal.spring_template.enums.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentType {

    FORM, // bieu mau
    NOTIFICATION, // thong bao
    ALL; // Dành cho tat ca

    public static boolean checkDocumentType(String s){
        try {
            DocumentType documentType = DocumentType.valueOf(s);
            return documentType == FORM || documentType == NOTIFICATION ||  documentType == ALL;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
