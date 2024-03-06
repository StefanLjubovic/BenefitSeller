package com.backend.payment.handler;

import com.backend.payment.exception.InsufficientBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InsufficientBalanceHandler {

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleInvalidDate(InsufficientBalanceException exception){
        return exception.getMessage();
    }
}
