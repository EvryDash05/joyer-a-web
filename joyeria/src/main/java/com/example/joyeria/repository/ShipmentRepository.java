package com.example.joyeria.repository;

import com.example.joyeria.entities.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<ShipmentEntity, String> {
    @Query("SELECT s FROM ShipmentEntity s WHERE s.customer.customerId = :customerId")
    List<ShipmentEntity> findByCustomerId(@Param("customerId") String customerId);
}
