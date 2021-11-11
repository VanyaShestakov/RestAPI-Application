package com.ivanshestakov.rest_api.rest.exceptionhandlers;

import com.ivanshestakov.rest_api.rest.exceptions.ExceptionInfo;
import com.ivanshestakov.rest_api.rest.exceptions.IncorrectJSONException;
import com.ivanshestakov.rest_api.rest.exceptions.NoSuchPatientException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleIncorrectJSONException(IncorrectJSONException exception) {
        ExceptionInfo info = new ExceptionInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleNoSuchPatientException(NoSuchPatientException exception) {
        ExceptionInfo info = new ExceptionInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

}
