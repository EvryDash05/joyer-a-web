package com.example.joyeria.models.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequest {
    private String address;
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();
    private String city;
    private String zipCode;
    private String customerName;
}
