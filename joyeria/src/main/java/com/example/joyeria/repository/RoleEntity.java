package com.example.joyeria.repository;

import com.example.joyeria.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    List<RoleEntity> findByRoleNameIn(List<String> roleNames);
}