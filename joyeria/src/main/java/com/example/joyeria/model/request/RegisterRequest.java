package com.example.joyeria.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
}
