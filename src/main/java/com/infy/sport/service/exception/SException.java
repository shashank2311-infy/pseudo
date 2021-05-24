package com.infy.sport.service.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class SException {
    private String message;
    private Date date;
    private HttpStatus httpStatus;

    public SException(String message, Date date, HttpStatus httpStatus) {
        this.message = message;
        this.date = date;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
