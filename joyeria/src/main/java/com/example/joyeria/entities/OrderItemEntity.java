package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderItemPk.class)
@Table(name = DatabaseConstant.ORDER_ITEM_TABLE)
public class OrderItemEntity {

    @Id
    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.ORDER_ID,
            referencedColumnName = DatabaseConstant.ORDER_ID
    )
    private OrderEntity order;

    @Id
    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.PRODUCT_ID,
            referencedColumnName = DatabaseConstant.PRODUCT_ID
    )
    private ProductEntity product;

    @Column(name = DatabaseConstant.ORDER_ITEM_QUANTITY, nullable = false)
    private Integer quantity;

    @Column(name = DatabaseConstant.ORDER_ITEM_PRICE, nullable = false)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal totalPrice;

    @Column(name = DatabaseConstant.ORDER_UNIT_PRICE, nullable = false)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal unitPrice;

}
