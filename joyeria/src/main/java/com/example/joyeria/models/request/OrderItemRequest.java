package com.example.joyeria.models.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
    private String productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal unitPrice;
}
