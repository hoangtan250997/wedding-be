package com.personalproject.jarsmanagement.exception;

import org.springframework.http.HttpStatus;

public class JarsManagementException {

    private static final String USER_NOT_FOUND_MSG_KEY = "UserNotExisted";
    private static final String USER_NOT_FOUND_MSG = "User Not Found";

    private static final String ACCOUNT_NOT_FOUND_MSG_KEY = "AccountNotExisted";
    private static final String ACCOUNT_NOT_FOUND_MSG = "Account Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException UserNotFound() {
        return notFound(USER_NOT_FOUND_MSG_KEY, USER_NOT_FOUND_MSG);
    }
    public static ResponseException AccountNotFound() {
        return notFound(ACCOUNT_NOT_FOUND_MSG_KEY, ACCOUNT_NOT_FOUND_MSG);
    }
}