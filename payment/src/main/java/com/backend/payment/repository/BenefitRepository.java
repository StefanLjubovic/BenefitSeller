package com.backend.payment.repository;

import com.backend.payment.model.BenefitCategory;
import com.backend.payment.model.BenefitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BenefitRepository extends JpaRepository<BenefitEntity,Integer> {

    Optional<BenefitEntity> findByBenefitCategory_CategoryNameAndName(String categoryName, String name);
}
