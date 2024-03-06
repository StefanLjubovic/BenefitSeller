package com.backend.payment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BenefitEntity extends BaseEntity{
    @Column(name="name", unique=false, nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "benefit_category_id", nullable = false)
    private BenefitCategory benefitCategory;
}
