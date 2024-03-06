package com.backend.payment.controller;


import com.backend.payment.dto.Transaction;
import com.backend.payment.dto.TransactionResponseDTO;
import com.backend.payment.model.TransactionStatus;
import com.backend.payment.service.serviceInterface.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@ControllerAdvice
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveCourt(@Validated @RequestBody Transaction transactionDto){
        return transactionService.save(transactionDto);
    }

    @GetMapping("{transactionStatus}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponseDTO> getTransactionsByStatus(@PathVariable TransactionStatus transactionStatus){
        return transactionService.getByStatus(transactionStatus);
    }
}
