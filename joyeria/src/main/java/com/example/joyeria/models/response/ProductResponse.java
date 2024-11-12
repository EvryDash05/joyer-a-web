package com.example.joyeria.models.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private byte[] img;
}
