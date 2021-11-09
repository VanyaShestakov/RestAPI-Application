package com.ivanshestakov.rest_api.rest.exceptions;

public class NoSuchPatientException extends RuntimeException{
    public NoSuchPatientException() {
        super();
    }

    public NoSuchPatientException(String message) {
        super(message);
    }

    public NoSuchPatientException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPatientException(Throwable cause) {
        super(cause);
    }

    protected NoSuchPatientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
