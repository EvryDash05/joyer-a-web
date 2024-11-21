package com.example.joyeria.controller;

import com.example.joyeria.models.request.OrderRequest;
import com.example.joyeria.models.request.PaymentRequest;
import com.example.joyeria.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/processOrder")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> processPurchase(@RequestBody OrderRequest orderRequest) {
        this.orderService.createOrder(orderRequest);
        return ResponseEntity.ok("Order created successfully");
    }

}
