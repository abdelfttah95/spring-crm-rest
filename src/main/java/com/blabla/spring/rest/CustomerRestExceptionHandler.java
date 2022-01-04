package com.blabla.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author abdel
 */
@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {

        CustomerErrorResponse error = new CustomerErrorResponse(
                                                                                    HttpStatus.NOT_FOUND.value(),
                                                                                    ex.getMessage(),
                                                                                    System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add an exception handler to catch any other exceptions ..
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {

        CustomerErrorResponse error = new CustomerErrorResponse(
                                                                                    HttpStatus.BAD_REQUEST.value(),
                                                                                    ex.getMessage(),
                                                                                    System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
