package com.example.joyeria.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCreateUserRequest {
    private String username;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<String> roles;
}
