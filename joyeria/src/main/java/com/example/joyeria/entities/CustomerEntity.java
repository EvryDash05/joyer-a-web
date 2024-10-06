package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.CUSTOMER_TABLE)
public class CustomerEntity {

    @Id
    @Column(name = DatabaseConstant.CUSTOMER_ID, length = 6, nullable = false)
    private String customerId;

    @Column(name = DatabaseConstant.USERNAME, length = 50, nullable = false)
    private String username;

    @Column(name = DatabaseConstant.LASTNAME, length = 50, nullable = false)
    private String lastname;

    @Column(name = DatabaseConstant.EMAIL, length = 100, nullable = false)
    private String email;

    @Column(name = DatabaseConstant.PASSWORD, length = 100, nullable = false)
    private String password;

    @Column(name = DatabaseConstant.PHONE, length = 11, nullable = false)
    private String phone;

    @Column(name = DatabaseConstant.ADDRESS, length = 100, nullable = false)
    private String address;

/*    @ManyToMany
    @JoinTable(
            name = DatabaseConstant.CUSTOMER_ROLE_TABLE,
            joinColumns = @JoinColumn(name = DatabaseConstant.CUSTOMER_ID),
            inverseJoinColumns = @JoinColumn(name = DatabaseConstant.CUSTOMER_ROLE_ROLE_ID)
    )
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "customer")
    private List<ShipmentEntity> shipments;

    @OneToMany(mappedBy = "customer")
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;*/

}
