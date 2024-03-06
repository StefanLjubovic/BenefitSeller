package com.backend.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BenefitCategory extends BaseEntity{
    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;
}
