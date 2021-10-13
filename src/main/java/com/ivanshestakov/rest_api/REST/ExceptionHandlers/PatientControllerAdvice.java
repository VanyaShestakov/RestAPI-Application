package com.ivanshestakov.rest_api.REST.ExceptionHandlers;

import com.ivanshestakov.rest_api.REST.Exceptions.IncorrectJSONData;
import com.ivanshestakov.rest_api.REST.Exceptions.IncorrectJSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<IncorrectJSONData> handleIncorrectJSONException(IncorrectJSONException exception) {
        IncorrectJSONData data = new IncorrectJSONData(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
