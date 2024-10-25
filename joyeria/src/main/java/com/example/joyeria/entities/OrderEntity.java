package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.ORDER_TABLE)
public class OrderEntity {

    @Id
    @Column(name = DatabaseConstant.ORDER_ID, nullable = false, length = 6)
    private String orderId;

    @Column(name = DatabaseConstant.ORDER_DATE, nullable = false)
    private LocalDateTime orderDate;

    @Column(name = DatabaseConstant.TOTAL_PRICE, nullable = false)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.CUSTOMER_ID,
            referencedColumnName = DatabaseConstant.CUSTOMER_ID
    )
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.SHIPMENT_ID,
            referencedColumnName = DatabaseConstant.SHIPMENT_ID
    )
    private ShipmentEntity shipment;

    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.PAYMENT_ID,
            referencedColumnName = DatabaseConstant.PAYMENT_ID
    )
    private PaymentEntity payment;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;

}