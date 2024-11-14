package com.example.joyeria.service;

import com.example.joyeria.entities.PaymentEntity;
import com.example.joyeria.models.request.PaymentRequest;
import com.example.joyeria.models.response.PaymentResponse;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    List<PaymentResponse> getAllPayments();
    PaymentEntity createPayment(PaymentRequest paymentRequest, BigDecimal amount);
    PaymentResponse getPaymentById(String paymentId);
    void deleteByPaymentId(String paymentId);
    void updatePayment(PaymentRequest paymentRequest, String paymentId);
}
