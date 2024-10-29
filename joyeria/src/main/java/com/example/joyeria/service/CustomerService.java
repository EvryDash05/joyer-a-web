package com.example.joyeria.service;

import com.example.joyeria.models.request.AuthCreateUserRequest;
import com.example.joyeria.models.request.AuthLoginRequest;
import com.example.joyeria.models.request.CustomerRequest;
import com.example.joyeria.models.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomers();
    CustomerResponse createCustomer(AuthCreateUserRequest customerRequest);
    CustomerResponse getCustomerByEmail(String email);
    CustomerResponse validateCustomer(AuthLoginRequest request);
    CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId);
    void deleteCustomer(String customerId);
}
