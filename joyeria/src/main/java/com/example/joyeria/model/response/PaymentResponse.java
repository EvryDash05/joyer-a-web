package com.example.joyeria.model.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private String paymentResponse;
    private String paymentDate;
    private LocalDateTime date;
    private BigDecimal amount;
    private List<OrderResponse> orders;
}
