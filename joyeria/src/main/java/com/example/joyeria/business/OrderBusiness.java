package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.CustomerEntity;
import com.example.joyeria.entities.OrderEntity;
import com.example.joyeria.entities.PaymentEntity;
import com.example.joyeria.entities.ShipmentEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.OrderRequest;
import com.example.joyeria.models.response.OrderResponse;
import com.example.joyeria.repository.CustomerRepository;
import com.example.joyeria.repository.OrderRepository;
import com.example.joyeria.repository.ShipmentRepository;
import com.example.joyeria.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderBusiness implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ShipmentRepository shipmentRepository;
    private final OrderItemBusiness orderItemBusiness;
    private final PaymentBusiness paymentBusiness;

    @Override
    public List<OrderResponse> getAllOrders() {
        return this.orderRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createOrder(OrderRequest request) {
        Optional<CustomerEntity> findCustomer = this.customerRepository.findCustomerByEmail(request.getEmail());
        Optional<ShipmentEntity> findShipment = this.shipmentRepository.findById(request.getShipmentId());

        if (findCustomer.isPresent() && findShipment.isPresent()) {
            BigDecimal totalPrice = request.calculateTotalPrice().add(new BigDecimal(10));
            PaymentEntity payment = this.paymentBusiness.createPayment(request.getPaymentRequest(), totalPrice);
            OrderEntity newOrder = OrderEntity.builder()
                    .orderId(Utils.generateRandomId(Identifier.ORDER.getValue()))
                    .customer(findCustomer.get())
                    .shipment(findShipment.get())
                    .orderDate(request.getOrderDate())
                    .payment(payment)
                    .totalPrice(totalPrice)
                    .build();
            this.orderRepository.save(newOrder);
            request.getItems().forEach(p -> this.orderItemBusiness.createItemOrder(p, newOrder));
        } else {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.CUSTOMER_NOT_FOUND);
        }

    }

    @Override
    public OrderResponse getOrderById(String orderId) {
        Optional<OrderEntity> findOrder = this.orderRepository.findById(orderId);
        if (findOrder.isEmpty()) {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PAYMENT_NOT_FOUND);
        }
        return this.toResponse(findOrder.get());
    }

    @Override
    public void deleteByOrderId(String orderId) {
        Optional<OrderEntity> findOrder = this.orderRepository.findById(orderId);
        if (findOrder.isEmpty()) {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PAYMENT_NOT_FOUND);
        }
        this.orderRepository.delete(findOrder.get());
    }

    @Override
    public void updateOrder(OrderRequest request, String orderId) {

    }

    private OrderResponse toResponse(OrderEntity entity) {
        return new ModelMapper().map(entity, OrderResponse.class);
    }

}
