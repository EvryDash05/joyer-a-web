package com.example.joyeria.entities;

import com.example.joyeria.commons.constants.DatabaseConstant;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.ROLE_TABLE)
public class RoleEntity {

    @Id
    @Column(name = DatabaseConstant.ROLE_ID, nullable = false, length = 6)
    private String roleId;

    @Column(name = DatabaseConstant.ROLE_NAME, nullable = false, length = 30, unique = true)
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = DatabaseConstant.ROLE_AUTHORITY_TABLE,
            joinColumns = @JoinColumn(name = DatabaseConstant.ROLE_AUTHORITY_ROLE_ID),
            inverseJoinColumns = @JoinColumn(name = DatabaseConstant.ROLE_AUTHORITY_AUTHORITY_ID)
    )
    private Set<AuthorityEntity> authorities;

}
