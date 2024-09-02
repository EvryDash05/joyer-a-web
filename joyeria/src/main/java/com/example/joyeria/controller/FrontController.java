package com.example.joyeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/products")
    public String products(){
        return "products.html";
    }
}
