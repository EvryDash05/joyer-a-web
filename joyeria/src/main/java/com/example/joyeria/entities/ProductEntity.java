package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.PRODUCT_TABLE)
public class ProductEntity {

    @Id
    @Column(name = DatabaseConstant.PRODUCT_ID, nullable = false, length = 6)
    private String productId;

    @Column(name = DatabaseConstant.PRODUCT_NAME, nullable = false, length = 6)
    private String productName;

    @Column(name = DatabaseConstant.DESCRIPTION, nullable = false)
    private String description;

    @Column(name = DatabaseConstant.PRICE, nullable = false)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal price;

    @Column(name = DatabaseConstant.STOCK, nullable = false)
    private Integer stock;

    @Column(name = DatabaseConstant.URL_IMG, nullable = false)
    private String urlImg;

    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;

}
