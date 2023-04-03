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
    public String plus(@RequestParam("num1") Float a, @RequestParam("num2") Float b) {
        return buildViev("+", a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildViev("-", a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildViev("*", a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildViev("/", a, b);
    }

    private String buildViev(String operation, Float operand1, Float operand2) {
        if (operand1 == null) {
            return "Не передано первое число!";
        } else if (operand2 == null) {
            return "Не передано второе число!";
        }
        if ("/".equals(operation) && operand2 == 0) {
            return "Делить на 0 нельзя!";
        }
        float result;
        switch (operation) {
            default:
            case "+":
                result = calculatorService.plus(operand1, operand2);
                break;
            case "-":
                result = calculatorService.minus(operand1, operand2);
                break;
            case "*":
                result = calculatorService.multiply(operand1, operand2);
                break;
            case "/":
                result = calculatorService.divide(operand1, operand2);
                break;
        }
        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }
}
