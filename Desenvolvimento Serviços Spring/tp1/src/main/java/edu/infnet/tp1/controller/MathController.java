package edu.infnet.tp1.controller;

import edu.infnet.tp1.model.RequestNumber;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @GetMapping("/somar")
    public float getSomar(@RequestParam float num1, @RequestParam float num2) {
        return num1 + num2;
    }

    @PostMapping("/somar")
    public float postSomar(@RequestBody RequestNumber number) {
        return number.getNum1() + number.getNum2();
    }

    @GetMapping("/subtrair")
    public float getSubtrair(@RequestParam float num1, @RequestParam float num2) {
        return num1 - num2;
    }

    @PostMapping("/subtrair")
    public float postSubtrair(@RequestBody RequestNumber number) {
        return number.getNum1() - number.getNum2();
    }

    @GetMapping("/dividir")
    public float getDividir(@RequestParam float num1, @RequestParam float num2) {
        return num1 / num2;
    }

    @PostMapping("/dividir")
    public float postDividir(@RequestBody RequestNumber number) {
        return number.getNum1() / number.getNum2();
    }

    @GetMapping("/multiplicar")
    public float getMultiplicar(@RequestParam float num1, @RequestParam float num2) {
        return num1 * num2;
    }

    @PostMapping("/multiplicar")
    public float postMultiplicar(@RequestBody RequestNumber number) {
        return number.getNum1() * number.getNum2();
    }

    @GetMapping("/potencia")
    public float getPotencia(@RequestParam float num1, @RequestParam float num2) {
        return (float) Math.pow(num1, num2);
    }

    @PostMapping("/potencia")
    public float postPotencia(@RequestBody RequestNumber number) {
        return (float) Math.pow(number.getNum1(), number.getNum2());
    }
}
