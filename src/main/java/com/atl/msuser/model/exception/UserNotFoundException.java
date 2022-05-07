package com.atl.msuser.model.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
    private final String code;

    public UserNotFoundException(String message, String code){
        super(message);
        this.code = code;
    }
}
