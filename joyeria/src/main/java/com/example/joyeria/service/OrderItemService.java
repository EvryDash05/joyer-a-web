package com.example.joyeria.service;

import com.example.joyeria.entities.OrderEntity;
import com.example.joyeria.models.request.OrderItemRequest;
import com.example.joyeria.models.response.OrderItemResponse;

import java.util.List;

public interface OrderItemService {
    List<OrderItemResponse> getAllItemsByOrderId(String orderId);
    void createItemOrder(OrderItemRequest orderItemRequest, OrderEntity orderEntity);
}
