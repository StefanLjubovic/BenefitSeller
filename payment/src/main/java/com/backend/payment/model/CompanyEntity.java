package com.backend.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CompanyEntity extends BaseEntity{
    @Column(name="name", unique=false, nullable=false)
    private String name;

    @JsonIgnoreProperties("company")
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyBenefit> companyBenefits;
}
