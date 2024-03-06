package com.backend.payment.service.serviceInterface;

import com.backend.payment.model.UserEntity;

public interface UserService {
    UserEntity findByEmail(String username);
}
