/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.joyeria.controller;

import com.example.joyeria.business.UserDetailsBusiness;
import com.example.joyeria.models.request.AuthCreateUserRequest;
import com.example.joyeria.models.request.AuthLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/auth")
public class AuthenticacionController {

    private final UserDetailsBusiness userDetailsBusiness ;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginRequest request) {
        return ResponseEntity.ok(this.userDetailsBusiness.loginUser(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody AuthCreateUserRequest registerRequest){
        return ResponseEntity.ok(this.userDetailsBusiness.createUser(registerRequest));
    }

}
