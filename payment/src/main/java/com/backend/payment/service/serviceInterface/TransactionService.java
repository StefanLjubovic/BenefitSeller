package com.backend.payment.service.serviceInterface;

import com.backend.payment.dto.Transaction;
import com.backend.payment.dto.TransactionResponseDTO;
import com.backend.payment.model.TransactionEntity;
import com.backend.payment.model.TransactionStatus;

import java.util.List;

public interface TransactionService {
    Integer save(Transaction transactionDto);

    List<TransactionResponseDTO> getByStatus(TransactionStatus status);
}
