package com.backend.payment.repository;

import com.backend.payment.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {
}
