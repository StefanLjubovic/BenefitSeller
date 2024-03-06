package com.backend.payment.repository;

import com.backend.payment.model.TransactionEntity;
import com.backend.payment.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {

    List<TransactionEntity> findByTransactionStatus(TransactionStatus status);
}
