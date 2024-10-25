package com.example.joyeria.model.request;

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
