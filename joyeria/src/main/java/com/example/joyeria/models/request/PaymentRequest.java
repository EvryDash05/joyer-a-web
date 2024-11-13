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
    private String email;
    @Builder.Default
    private LocalDateTime paymentDate = LocalDateTime.now();
    private String paymentMethod;
}
