package com.weatherReporter.app.exception;


public class ExternalServiceException extends RuntimeException {

    public ExternalServiceException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
