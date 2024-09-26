package com.example.joyeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontController {

    @GetMapping("/")
    public String index(){
        return "login.html";
    }

    @GetMapping("/home")
    public String home(){ return "index.html"; }

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

}
