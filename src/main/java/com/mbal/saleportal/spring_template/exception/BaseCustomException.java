package com.mbal.saleportal.spring_template.exception;

import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseCustomException extends RuntimeException{

    private String message;
    private String errorCode;

    public BaseCustomException(DocumentResponseMessage responseMessage) {
        this.message = responseMessage.getMessage();
        this.errorCode = responseMessage.getCode();
    }

    public BaseCustomException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseCustomException(String message) {
        this.message = message;
    }
}
