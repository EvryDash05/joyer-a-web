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
public class PaymentRequest {
    private String customerName;
    @Builder.Default
    private LocalDateTime paymentDate = LocalDateTime.now();
    private BigDecimal amount;
    private String paymentMethod;
    private List<OrderItemRequest> orderTimeRequests;

    public BigDecimal calculateAmount(){
        return this.orderTimeRequests.stream()
                .map(OrderItemRequest::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}