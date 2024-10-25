package com.example.joyeria.model.request;

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
    private String customerName;
    private String shipmentId;
    private String paymentId;
    @Builder.Default
    private LocalDateTime orderDate = LocalDateTime.now();
    private BigDecimal totalPrice;
    private List<OrderItemRequest> items;

    public BigDecimal calculateTotalPrice(){
        this.totalPrice = this.items.stream()
                .map(OrderItemRequest::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.totalPrice;
    };

}
