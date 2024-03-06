package com.backend.payment.repository;

import com.backend.payment.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
}
