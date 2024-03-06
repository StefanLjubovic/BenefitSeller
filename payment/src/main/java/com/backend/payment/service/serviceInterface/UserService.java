package com.backend.payment.service.serviceInterface;

import com.backend.payment.dto.User;
import com.backend.payment.model.UserEntity;

public interface UserService {
    UserEntity findByEmail(String email);

    User getCardFunds(String email);
}
