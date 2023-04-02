package com.github.aza0602.calculator.controller;

import com.github.aza0602.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String hello() {
        return "<h1 style=\"text-align: center\">Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") float a, @RequestParam("num2") float b) {
        return a + " + " + b + " = " + calculatorService.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") float a, @RequestParam("num2") float b) {
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") float a, @RequestParam("num2") float b) {
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") float a, @RequestParam("num2") float b) {
        return a + " / " + b + " = " + calculatorService.divide(a, b);
    }
}
