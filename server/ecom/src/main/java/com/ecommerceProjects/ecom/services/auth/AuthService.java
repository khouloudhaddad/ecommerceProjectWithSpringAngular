package com.ecommerceProjects.ecom.services.auth;

import com.ecommerceProjects.ecom.dto.RegisterRequest;
import com.ecommerceProjects.ecom.dto.UserDto;

public interface AuthService {

    UserDto createUser(RegisterRequest registerRequest);
    Boolean hasUserWithEmail(String email);
}
