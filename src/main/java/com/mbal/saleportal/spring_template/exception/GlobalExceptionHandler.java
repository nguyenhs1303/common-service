package com.mbal.saleportal.spring_template.exception;

import com.mbal.saleportal.spring_template.dto.ApiBaseResponseError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiBaseResponseError handleException(Exception ex) {
        log.error(getExceptionExplain(ex));
        return ApiBaseResponseError.builder()
                .messages("Có lỗi xảy ra. Vui lòng thử lại")
                .errorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiBaseResponseError handleCustomException(BadRequestException ex) {
        log.error(getExceptionExplain(ex));
        return ApiBaseResponseError.builder()
                .messages(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();
    }

    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiBaseResponseError handleCustomException(InternalErrorException ex) {
        log.error(getExceptionExplain(ex));
        return ApiBaseResponseError.builder()
                .messages(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiBaseResponseError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(getExceptionExplain(ex));
        // Lấy danh sách các lỗi validation
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        // Tạo một danh sách để lưu trữ các thông báo lỗi
        List<String> errorMessages = new ArrayList<>();

        // Duyệt qua danh sách các lỗi validation và trích xuất message tương ứng
        for (FieldError fieldError : fieldErrors) {
            errorMessages.add(fieldError.getDefaultMessage());
        }
        return ApiBaseResponseError.builder()
                .messages(String.join(", ", errorMessages))
                .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .build();
    }

    public static String getExceptionExplain(Throwable throwable){
        return String.format("%s | %s | %s", throwable.toString(), throwable.getMessage(), ExceptionUtils.getStackTrace(throwable));
    }

}
