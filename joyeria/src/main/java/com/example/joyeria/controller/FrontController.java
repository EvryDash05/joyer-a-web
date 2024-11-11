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

    @GetMapping("/formHome")
    public String formHome(){ return "formHome.html"; }

    @GetMapping("/register")
    public String formRegister(){ return "registerForm.html"; }

    @GetMapping("/login")
    public String formLogin(){ return "login.html"; }

    @GetMapping("/productsForm")
    public String productsForm(){ return "productsForm.html"; }

    @GetMapping("/productDetail")
    public String productDetail(){ return "productDetail.html"; }

}
