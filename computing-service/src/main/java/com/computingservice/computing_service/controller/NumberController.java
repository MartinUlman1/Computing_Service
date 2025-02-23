package com.computingservice.computing_service.controller;


import com.computingservice.computing_service.service.NumberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/calculate/{number}")
    public long calculate(@PathVariable long number) {
        System.out.println("Received number: " + number); // Ladící výpis
        long result = numberService.processNumber(number);
        System.out.println("Result from service: " + result); // Ladící výpis
        return result;
    }
}
