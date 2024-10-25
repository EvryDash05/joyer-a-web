package com.example.joyeria.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String customerId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private List<OrderResponse> orders;
}
