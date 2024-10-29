package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.CustomerEntity;
import com.example.joyeria.entities.RoleEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.AuthCreateUserRequest;
import com.example.joyeria.models.request.AuthLoginRequest;
import com.example.joyeria.models.request.CustomerRequest;
import com.example.joyeria.models.response.CustomerResponse;
import com.example.joyeria.repository.CustomerRepository;
import com.example.joyeria.repository.RoleRepository;
import com.example.joyeria.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerBusiness implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerResponse createCustomer(AuthCreateUserRequest request) {
        Optional<CustomerEntity> findCustomer = customerRepository.findCustomerByEmail(request.getEmail());
        if (findCustomer.isPresent()) {
            throw new BusinessException(ErrorConstant.GENERIC_ERROR_CODE, ErrorConstant.INVALID_CREDENTIALS_MESSAGE);
        } else {
            RoleEntity findRole = this.roleRepository.findByRoleName("USER");
            Set<RoleEntity> roles = new HashSet<>();
            roles.add(findRole);
            CustomerEntity customer = CustomerEntity.builder()
                    .customerId(Utils.generateRandomId(Identifier.CUSTOMER.getValue()))
                    .username(request.getUsername())
                    .lastname(request.getLastName())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .roles(roles)
                    .build();
            return this.toResponse(this.customerRepository.save(customer));
        }
    }

    @Override
    public CustomerResponse getCustomerByEmail(String email) {
        Optional<CustomerEntity> findCustomer = this.customerRepository.findCustomerByEmail(email);
        if (findCustomer.isEmpty()) {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.CUSTOMER_NOT_FOUND);
        }
        return this.toResponse(findCustomer.get());
    }

    @Override
    public CustomerResponse validateCustomer(AuthLoginRequest request) {
        Optional<CustomerEntity> findCustomer = this.customerRepository.findCustomerByEmail(request.getEmail());
        if (findCustomer.isEmpty()) {
            throw new BusinessException(ErrorConstant.GENERIC_ERROR_CODE, ErrorConstant.INVALID_CREDENTIALS_MESSAGE);
        }
        if(findCustomer.get().getPassword().equals(request.getPassword())) {
            return this.toResponse(findCustomer.get());
        }else {
            throw new BusinessException(ErrorConstant.GENERIC_ERROR_CODE, ErrorConstant.INVALID_CREDENTIALS_MESSAGE);
        }
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    private CustomerResponse toResponse(CustomerEntity customerEntity) {
        return new ModelMapper().map(customerEntity, CustomerResponse.class);
    }

}
