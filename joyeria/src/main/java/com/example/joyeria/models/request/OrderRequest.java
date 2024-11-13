package com.example.joyeria.models.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String email;
    private String shipmentId;
    private PaymentRequest paymentRequest;
    @Builder.Default
    private LocalDateTime orderDate = LocalDateTime.now();
    private List<OrderItemRequest> items;

    public BigDecimal calculateTotalPrice(){
        return this.items.stream()
                .map(OrderItemRequest::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    };

}
