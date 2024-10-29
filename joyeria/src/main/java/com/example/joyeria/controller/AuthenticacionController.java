/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.joyeria.controller;

import com.example.joyeria.models.request.AuthCreateUserRequest;
import com.example.joyeria.models.request.AuthLoginRequest;
import com.example.joyeria.models.response.CustomerResponse;
import com.example.joyeria.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class AuthenticacionController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<CustomerResponse> login(@RequestBody AuthLoginRequest request) {
        return ResponseEntity.ok(this.customerService.getCustomerByEmail(request.getEmail()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody AuthCreateUserRequest registerRequest){
        return ResponseEntity.ok(this.customerService.createCustomer(registerRequest));
    }

}
