package com.example.joyeria.business;

import com.example.joyeria.models.request.CustomerRequest;
import com.example.joyeria.models.response.CustomerResponse;
import com.example.joyeria.service.CustomerService;

import java.util.List;

public class CustomerBusiness implements CustomerService {
    @Override
    public List<CustomerResponse> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }
}
