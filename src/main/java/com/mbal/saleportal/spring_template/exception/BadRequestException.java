package com.mbal.saleportal.spring_template.exception;

import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;

public class BadRequestException extends BaseCustomException{

    public BadRequestException(DocumentResponseMessage message){
        super(message);
    }

    public BadRequestException(String message){
        super(message);
    }
}
