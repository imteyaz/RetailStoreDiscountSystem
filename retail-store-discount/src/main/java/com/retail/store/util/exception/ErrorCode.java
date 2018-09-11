package com.retail.store.util.exception;

/**
 * ErrorCode contains all possible kind of exceptions to be handled in the application.
 * 
 * @author Imteyaz Ahmad
 *
 */
public enum ErrorCode {

    BILLING_EXCEPTION("100", "Billing Exception Occured");

    private String code;
    private String errorMessage;

    private ErrorCode(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.errorMessage = errorMessage;

    }

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
