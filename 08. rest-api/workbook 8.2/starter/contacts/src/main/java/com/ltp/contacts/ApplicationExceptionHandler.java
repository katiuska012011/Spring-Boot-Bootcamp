package com.ltp.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ltp.contacts.exception.ContactNoFoundException;
import com.ltp.contacts.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ContactNoFoundException.class)
    public ResponseEntity<Object> handleContactNotFoundException(ContactNoFoundException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
}
