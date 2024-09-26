/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.joyeria.controller;

import com.example.joyeria.model.request.LoginAuthRequest;
import com.example.joyeria.model.request.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AuthenticacionController {

    @GetMapping("/loginForm")
    public ModelAndView showLoginForm() {
        ModelAndView modelandview = new ModelAndView("login");
        modelandview.addObject("loginRequest", new LoginAuthRequest());
        return modelandview;
    }

    @PostMapping("/loginForm")
    public ModelAndView loginForm(@ModelAttribute LoginAuthRequest loginRequest, RedirectAttributes redirectAttributes) {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("index");
        return modelandview;
    }

    @GetMapping("/registerForm")
    public ModelAndView showRegisterForm(Model model) {
        ModelAndView modelandview = new ModelAndView("registerForm");
        modelandview.addObject("registerRequest", new RegisterRequest());
        return modelandview;
    }

    @PostMapping("/registerForm")
    public ModelAndView createUser(@ModelAttribute RegisterRequest registerRequest){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
