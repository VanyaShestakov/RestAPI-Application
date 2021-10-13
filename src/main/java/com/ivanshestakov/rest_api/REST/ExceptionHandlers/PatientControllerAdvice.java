package com.ivanshestakov.rest_api.REST.ExceptionHandlers;

import com.ivanshestakov.rest_api.REST.Exceptions.ExceptionInfo;
import com.ivanshestakov.rest_api.REST.Exceptions.IncorrectJSONException;
import com.ivanshestakov.rest_api.REST.Exceptions.NoSuchPatientException;
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
