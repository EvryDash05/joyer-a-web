package com.example.joyeria.service;

import com.example.joyeria.models.request.ShipmentRequest;
import com.example.joyeria.models.response.ShipmentResponse;

import java.util.List;

public interface ShipmentService {
    List<ShipmentResponse> getAllShipments();
    void createShipment(ShipmentRequest shipmentRequest);
    ShipmentResponse getShipmentById(String shipmentId);
    List<ShipmentResponse> findShipmentListByCustomerId(String customerId);
    void updateShipment(ShipmentRequest shipmentRequest);
    void deleteByShipmentId(String shipmentId);
}
