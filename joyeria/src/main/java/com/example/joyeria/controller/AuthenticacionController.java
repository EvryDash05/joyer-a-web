/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.joyeria.controller;

import ch.qos.logback.core.model.Model;
import com.example.joyeria.model.request.LoginAuthRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Edu
 */
@Controller
public class AuthenticacionController {

    @GetMapping("/loginForm")
    public ModelAndView ShowloginForm() {
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
}
