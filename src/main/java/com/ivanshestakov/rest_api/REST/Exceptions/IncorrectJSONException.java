package com.ivanshestakov.rest_api.REST.Exceptions;

public class IncorrectJSONException extends RuntimeException {
    public IncorrectJSONException() {
        super();
    }

    public IncorrectJSONException(String message) {
        super(message);
    }

    public IncorrectJSONException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectJSONException(Throwable cause) {
        super(cause);
    }

    protected IncorrectJSONException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
