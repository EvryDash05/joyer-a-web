package com.example.joyeria.models.response;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse{
    private String customerId;
    private String username;
    private String email;
    private String message;
    private String token;
    private boolean status;
    private List<String> roles;
}
