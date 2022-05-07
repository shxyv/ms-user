package com.atl.msuser.controller;


import com.atl.msuser.model.dto.ExceptionDto;
import com.atl.msuser.model.exception.UserAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.atl.msuser.model.exception.ExceptionConstants.*;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionDto handleCommonException(Exception ex) {
        log.error("Unexpected exception, message: {}, cause: {}",
                ex.getMessage(), ex.getCause());
        return new ExceptionDto(
                UNEXPECTED_EXCEPTION_CODE,
                UNEXPECTED_EXCEPTION_MESSAGE
        );
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ExceptionDto handleUserAlreadyExistsException(UserAlreadyExistsException ex){
        log.error("User already exists, message: {}, code: {}",
                ex.getMessage(), ex.getCode());
        return new ExceptionDto(
                ex.getCode(),
                ex.getMessage()
        );
    }
}
