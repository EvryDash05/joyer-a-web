package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.CustomerEntity;
import com.example.joyeria.entities.PaymentEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.PaymentRequest;
import com.example.joyeria.models.response.PaymentResponse;
import com.example.joyeria.repository.CustomerRepository;
import com.example.joyeria.repository.PaymentRepository;
import com.example.joyeria.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentBusiness implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository CustomerRepository;


    @Override
    public List<PaymentResponse> getAllPayments() {
        return this.paymentRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createPayment(PaymentRequest paymentRequest) {
        Optional<CustomerEntity> findCustomer = this.CustomerRepository.findCustomerByUsername(paymentRequest.getCustomerName());
        if (findCustomer.isPresent()) {
            BigDecimal amount = paymentRequest.calculateAmount();
            PaymentEntity newPayment = PaymentEntity.builder()
                    .paymentId(Utils.generateRandomId(Identifier.PAYMENT.getValue()))
                    .paymentDate(paymentRequest.getPaymentDate())
                    .amount(amount)
                    .paymentMethod(paymentRequest.getPaymentMethod())
                    .customer(findCustomer.get())
                    .build();
            this.paymentRepository.save(newPayment);
        } else {
            throw new BusinessException(ErrorConstant.GENERIC_ERROR_CODE, ErrorConstant.GENERIC_ERROR_MESSAGE);
        }
    }

    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        Optional<PaymentEntity> findPayment = this.paymentRepository.findById(paymentId);
        if(findPayment.isEmpty()){
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PAYMENT_NOT_FOUND);
        }
        return this.toResponse(findPayment.get());
    }

    @Override
    public void deleteByPaymentId(String paymentId) {
        Optional<PaymentEntity> findPayment = this.paymentRepository.findById(paymentId);
        if(findPayment.isEmpty()){
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PAYMENT_NOT_FOUND);
        }
        this.paymentRepository.delete(findPayment.get());
    }

    @Override
    public void updatePayment(PaymentRequest paymentRequest, String paymentId) {

    }

    private PaymentResponse toResponse(PaymentEntity entity) {
        return new ModelMapper().map(entity, PaymentResponse.class);
    }

}
