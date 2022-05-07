package com.atl.msuser.model.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException{

    private final String code;

    public UserAlreadyExistsException(String message, String code){
        super(message);
        this.code = code;
    }
}
