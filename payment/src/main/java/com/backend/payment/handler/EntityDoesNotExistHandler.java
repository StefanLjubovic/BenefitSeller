package com.backend.payment.handler;

import com.backend.payment.exception.EntityDoesNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityDoesNotExistHandler {

    @ExceptionHandler(EntityDoesNotExistsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleInvalidDate(EntityDoesNotExistsException exception){
        return exception.getMessage();
    }
}
