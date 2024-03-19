package com.ecommerceProjects.ecom.dto;

import com.ecommerceProjects.ecom.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private  Long id;
    
    private String name;

    private String email;

    private UserRole userRole;
    
}
