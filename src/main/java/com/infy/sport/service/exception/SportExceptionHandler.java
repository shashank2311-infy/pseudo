package com.infy.sport.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.logging.Logger;

@ControllerAdvice
public class SportExceptionHandler {
    Logger logger=Logger.getLogger(SportExceptionHandler.class.getName());
    @ExceptionHandler(value ={Exception.class})
    public ResponseEntity<Object> handler(Exception e)
    {
        logger.info("Inside GenericException Handler of Centralized Exception Handler");
        SException se=new SException(e.getMessage(), new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(se, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value ={SportException.class})
    public ResponseEntity<Object> sportExceptionHandler(SportException e)
    {
        logger.info("Inside SportException Handler of Centralized Exception Handler");
        SException se=new SException(e.getMessage(), new Date(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value ={MethodArgumentNotValidException.class})
    public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e)
    {
        logger.info("Inside MethodArgumentNotValidException Handler of Centralized Exception Handler");
        SException se=new SException(e.getMessage(), new Date(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
    }
}
