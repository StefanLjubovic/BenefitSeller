package com.backend.payment.service.serviceInterface;

import com.backend.payment.dto.Transaction;

public interface TransactionService {
    Integer save(Transaction transactionDto);
}
