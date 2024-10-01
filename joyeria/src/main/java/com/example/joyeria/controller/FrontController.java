package com.example.joyeria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/front")
public class FrontController {

    private final MessageSource messageSource;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){ return "index"; }

    @GetMapping("/products")
    public String products(){
        return "products.html";
    }

    @GetMapping("/aboutUs")
    public String aboutUs(){ return "about_us.html"; }

    @GetMapping("/shoppingCart")
    public String shoppingCart(){ return "shopping_cart.html"; }

    @GetMapping("/customerData")
    public String customerData(){ return "formCustomerData.html"; }

    @GetMapping("/formHome")
    public String formHome(){ return "formHome.html"; }
}
