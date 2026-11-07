package com.example.Labrbp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabController {

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Мир") String name) {
        return "Привет, " + name + "! Запущено удачно";
    }

    @GetMapping("/numbers")
    public List<Integer> getNumbers() {
        return List.of(1, 2, 3, 5, 8, 13, 21);
    }
}