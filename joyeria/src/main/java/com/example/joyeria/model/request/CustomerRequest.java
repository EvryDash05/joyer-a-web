package com.example.joyeria.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
