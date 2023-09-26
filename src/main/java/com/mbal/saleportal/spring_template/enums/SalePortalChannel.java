package com.mbal.saleportal.spring_template.enums;

import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;
import com.mbal.saleportal.spring_template.exception.BadRequestException;

public enum SalePortalChannel {

    BANCA,
    AGENCY,
    ALL;

    public static void checkChannel(String channel) {
        try {
            valueOf(channel);
        }catch (Exception e){
            throw new BadRequestException(DocumentResponseMessage.SALE_PORTAL_CHANNEL_INVALID);
        }
    }
}
