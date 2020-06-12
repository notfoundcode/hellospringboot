package com.notfoundcode.hellobpringboot.application.resource.advise;

import com.notfoundcode.hellobpringboot.infraestructure.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewsletterAdvise {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity handleNonExistingSubscription(IdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
