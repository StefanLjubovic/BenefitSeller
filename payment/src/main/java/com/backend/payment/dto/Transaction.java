package com.backend.payment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction {
    @NotNull(message = "Value is mandatory")
    private Long value;

    @NotEmpty(message = "Benefit name is mandatory")
    private String benefitName;

    @NotEmpty(message = "Category is mandatory")
    private String category;

    @Email(message = "Invalid email format")
    private String email;
}
