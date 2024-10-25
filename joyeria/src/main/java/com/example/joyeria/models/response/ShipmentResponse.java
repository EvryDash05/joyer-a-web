package com.example.joyeria.models.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResponse {
    private String shipmentId;
    private LocalDateTime shipmentDate;
    private String address;
    private String city;
    private String zipCode;
}
