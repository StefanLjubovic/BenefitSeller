package com.backend.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CompanyBenefit extends BaseEntity{

    private Long discount;
    @ManyToOne
    @JoinColumn(name = "benefit_id", nullable = false)
    private BenefitEntity benefit;
}
