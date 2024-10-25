package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.SHIPMENT_TABLE)
public class ShipmentEntity {

    @Id
    @Column(name = DatabaseConstant.SHIPMENT_ID, nullable = false, length = 6)
    private String shipmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = DatabaseConstant.SHIPMENT_DATE, nullable = false)
    private LocalDateTime shipmentDate;

    @Column(name = DatabaseConstant.SHIPMENT_ADDRESS, nullable = false, length = 100)
    private String address;

    @Column(name = DatabaseConstant.CITY, nullable = false, length = 100)
    private String city;

    @Column(name = DatabaseConstant.ZIP_CODE, nullable = false, length = 10)
    private String zipCode;

    @ManyToOne
    @JoinColumn(
            name = DatabaseConstant.CUSTOMER_ID,
            referencedColumnName = DatabaseConstant.CUSTOMER_ID
    )
    private CustomerEntity customer;

    @OneToMany(mappedBy = "shipment")
    private List<OrderEntity> shipments;

}
