package com.example.joyeria.service;

import com.example.joyeria.models.request.CustomerRequest;
import com.example.joyeria.models.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomers();
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId);
    void deleteCustomer(String customerId);
}
