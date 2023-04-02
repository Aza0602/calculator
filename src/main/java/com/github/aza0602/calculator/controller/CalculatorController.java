package com.github.aza0602.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculator")
    public String hello() {
        return "<h1 style=\"text-align: center\">Добро пожаловать в калькулятор</h1>";
    }

}
