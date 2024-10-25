package com.example.joyeria.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse{
    private String username;
    private String message;
    private String token;
    private boolean status;
}
