package com.example.joyeria.controller;

import com.example.joyeria.models.request.ShipmentRequest;
import com.example.joyeria.models.response.ShipmentResponse;
import com.example.joyeria.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/findByShipmentId/{shipmentId}")
    public ResponseEntity<ShipmentResponse> findByShipmentId(@PathVariable String shipmentId) {
        return ResponseEntity.ok(shipmentService.getShipmentById(shipmentId));
    }

    @PostMapping("/registerShipment")
    public ResponseEntity<String> registerShipment(@RequestBody ShipmentRequest shipmentRequest) {
        shipmentService.createShipment(shipmentRequest);
        return ResponseEntity.ok("Shipment registered successfully");
    }

    @GetMapping("/findShipmentListByCustomerId/{customerId}")
    public ResponseEntity<List<ShipmentResponse>> findShipmentListByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(shipmentService.findShipmentListByCustomerId(customerId));
    }

}
