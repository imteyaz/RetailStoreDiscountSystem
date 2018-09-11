package com.retail.store.util.exception;

import java.util.Date;

/**
 * Application level Exception wrapper to be used
 * 
 * @author Imteyaz Ahmad
 *
 */
public class StoreBillingException extends Exception {

    private static final long serialVersionUID = 2361182336785766503L;

    private final String errorMessage;
    private final Date exceptionDate;
    private final ErrorCode errorCode;

    public StoreBillingException(ErrorCode exceptionCode, String errorMessage) {
        super(errorMessage);
        this.exceptionDate = new Date();
        this.errorMessage = errorMessage;
        this.errorCode = exceptionCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Date getExceptionDate() {
        return exceptionDate;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
