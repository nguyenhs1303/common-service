package com.mbal.saleportal.spring_template.enums.document;

public enum DocumentNotificationStatus {

    ACTIVE,
    DE_ACTIVE,
    DELETE;

    public static DocumentNotificationStatus convertFromString(String s) {
        try {
            return valueOf(s);
        } catch (Exception e) {
            return null;
        }
    }

}
