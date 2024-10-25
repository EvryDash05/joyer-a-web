package com.example.joyeria.service;

import com.example.joyeria.models.request.OrderRequest;
import com.example.joyeria.models.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders();
    void createOrder(OrderRequest request);
    OrderResponse getOrderById(String orderId);
    void deleteByOrderId(String orderId);
    void updateOrder(OrderRequest request, String orderId);
}
