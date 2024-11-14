package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.entities.OrderEntity;
import com.example.joyeria.entities.OrderItemEntity;
import com.example.joyeria.entities.ProductEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.OrderItemRequest;
import com.example.joyeria.models.response.OrderItemResponse;
import com.example.joyeria.repository.OrderItemRepository;
import com.example.joyeria.repository.OrderRepository;
import com.example.joyeria.repository.ProductRepository;
import com.example.joyeria.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemBusiness implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public List<OrderItemResponse> getAllItemsByOrderId(String orderId) {
        Optional<OrderEntity> findOrderEntity = orderRepository.findById(orderId);
        if (findOrderEntity.isPresent()) {
            return findOrderEntity.get().getOrderItems()
                    .stream().map(this::toResponse)
                    .toList();
        } else {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.ORDER_NOT_FOUND);
        }
    }

    @Override
    public void createItemOrder(OrderItemRequest orderItemRequest, OrderEntity orderEntity) {
        Optional<ProductEntity> findProduct = this.productRepository.findById(orderItemRequest.getProductId());
        BigDecimal totalPrice = findProduct.get().getPrice().multiply(new BigDecimal(orderItemRequest.getQuantity()));
        OrderItemEntity newOrderItemEntity = OrderItemEntity.builder()
                .order(orderEntity)
                .product(findProduct.get())
                .quantity(orderItemRequest.getQuantity())
                .unitPrice(findProduct.get().getPrice())
                .totalPrice(totalPrice)
                .build();
        log.info("Order item: {}", newOrderItemEntity);
        this.discountProductStock(findProduct.get(), orderItemRequest.getQuantity());
        this.orderItemRepository.save(newOrderItemEntity);
    }

    private void discountProductStock(ProductEntity product, int quantity) {
        if (product.getStock() > 0) {
            product.setStock(product.getStock() - quantity);
            this.productRepository.save(product);
        }
    }

    private OrderItemResponse toResponse(OrderItemEntity orderItemEntity) {
        return new ModelMapper().map(orderItemEntity, OrderItemResponse.class);
    }

}
