package com.example.joyeria.model.response;

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
    private Integer quantity;
    private String imageUrl;
}
