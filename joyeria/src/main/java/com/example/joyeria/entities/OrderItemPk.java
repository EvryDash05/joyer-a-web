package com.example.joyeria.entities;

import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPk {
    private String order;
    private String product;
}