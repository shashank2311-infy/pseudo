package com.infy.sport.service.exception;

public class SportException extends Exception{
    private static final long serialVersionUID=1L;
    public SportException(String message){
        super(message);
    }

    public SportException(String message, Throwable cause) {
        super(message, cause);
    }
}
