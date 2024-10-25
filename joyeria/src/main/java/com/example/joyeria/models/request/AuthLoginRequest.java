package com.example.joyeria.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginRequest {
    @NotBlank  private String username;
    @NotBlank  private String password;
}