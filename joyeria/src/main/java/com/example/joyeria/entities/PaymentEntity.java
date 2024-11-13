package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.PAYMENT_TABLE)
public class PaymentEntity {

    @Id
    @Column(name = DatabaseConstant.PAYMENT_ID, nullable = false, length = 6)
    private String paymentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = DatabaseConstant.PAYMENT_DATE, nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = DatabaseConstant.PAYMENT_METHOD, nullable = false, length = 100)
    private String paymentMethod;

    @Column(name = DatabaseConstant.AMOUNT, nullable = false)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.CUSTOMER_ID,
            referencedColumnName = DatabaseConstant.CUSTOMER_ID
    )
    private CustomerEntity customer;

    @OneToOne(mappedBy = "payment")
    private OrderEntity order;

}