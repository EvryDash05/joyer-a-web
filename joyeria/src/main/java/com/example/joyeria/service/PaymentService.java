package com.example.joyeria.service;

import com.example.joyeria.models.request.PaymentRequest;
import com.example.joyeria.models.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> getAllPayments();
    void createPayment(PaymentRequest paymentRequest);
    PaymentResponse getPaymentById(String paymentId);
    void deleteByPaymentId(String paymentId);
    void updatePayment(PaymentRequest paymentRequest, String paymentId);
}
