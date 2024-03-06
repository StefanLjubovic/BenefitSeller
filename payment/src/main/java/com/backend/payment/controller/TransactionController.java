package com.backend.payment.controller;


import com.backend.payment.dto.Transaction;
import com.backend.payment.service.serviceInterface.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@ControllerAdvice
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveCourt(@RequestBody Transaction transactionDto){
        return transactionService.save(transactionDto);
    }
}
