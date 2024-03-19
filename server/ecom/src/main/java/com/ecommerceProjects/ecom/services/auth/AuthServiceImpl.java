package com.ecommerceProjects.ecom.services.auth;

import com.ecommerceProjects.ecom.dto.RegisterRequest;
import com.ecommerceProjects.ecom.dto.UserDto;
import com.ecommerceProjects.ecom.entity.User;
import com.ecommerceProjects.ecom.enums.UserRole;
import com.ecommerceProjects.ecom.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements  AuthService{

    @Autowired
    private UserRepository userRepository;
    
    public UserDto createUser(RegisterRequest registerRequest){
        User user = new User();
        
        user.setEmail(registerRequest.getEmail());
        user.setName(registerRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        user.setRole(UserRole.GUEST);
        
        User createdUser = userRepository.save(user);
        
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        
        return userDto;
    }
    
    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }
    
    @PostConstruct
    public void createAdminAccount(){
        User adminUser = userRepository.findByRole(UserRole.ADMIN);
        if(null == adminUser){
            User user = new User();
            user.setEmail("admin@admin.com");
            user.setName("Admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("root"));
            
            userRepository.save(user);
        }
    }
}
