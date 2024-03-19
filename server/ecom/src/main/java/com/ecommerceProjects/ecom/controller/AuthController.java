package com.ecommerceProjects.ecom.controller;

import com.ecommerceProjects.ecom.dto.AuthenticationRequest;
import com.ecommerceProjects.ecom.entity.User;
import com.ecommerceProjects.ecom.repository.UserRepository;
import com.ecommerceProjects.ecom.utils.JwtUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    
    private final UserDetailsService userDetailsService;
    
    private final UserRepository userRepository;
    
    private final JwtUtil jwtUtil;
    
    public final String TOKEN_PREFIX = "Bearer ";
    public final String HEADER_STRING = "Authorization";
    
    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch(BadCredentialsException e){
            throw  new BadCredentialsException("Incorrect username or password.");
        }
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        
        if(optionalUser.isPresent()){
            response.getWriter().write(new JSONPObject()
                    .put("userId", optionalUser.get().getId())
                    .put("role", optionalUser.get().getRole())
                    .toString()
            );
            response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
        }
    }
}
