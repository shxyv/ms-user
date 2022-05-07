package com.atl.msuser.model.exception;

public class ExceptionConstants {

    public static final String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION_CODE";
    public static final String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected error occurred";

    public static final String USER_ALREADY_EXISTS_EXCEPTION_CODE = "USER_ALREADY_EXISTS_EXCEPTION_CODE";
    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE =
            "User with email %s already exists!";



    public static final String USER_NOT_FOUND_EXCEPTION_CODE = "USER_NOT_FOUND_EXCEPTION";
    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_EMAIL = "User with email %s not found!";
    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_ID = "User with id %s not found!";
}
