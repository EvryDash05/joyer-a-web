package com.example.joyeria.models.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String orderId;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private ShipmentResponse shipment;
    private PaymentResponse payment;
    private List<OrderItemResponse> products;
}
