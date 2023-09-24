package com.mbal.saleportal.spring_template.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InternalErrorException extends BaseCustomException{

    public InternalErrorException(String message, String errorCode) {
        super(message, errorCode);
    }

}
