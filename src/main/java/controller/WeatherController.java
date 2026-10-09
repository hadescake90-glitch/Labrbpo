package com.example.Labrbp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    // 1-й GET-эндпоинт: возвращает текстовый отчет о состоянии станции
    @GetMapping("/status")
    public String getStationStatus(@RequestParam(defaultValue = "Центральная") String station) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "Метеостанция [" + station + "] функционирует штатно. Время замера: " + timestamp;
    }

    // 2-й GET-эндпоинт: возвращает список чисел (прогноз температур)
    @GetMapping("/forecast")
    public List<Double> getWeeklyForecast(@RequestParam(defaultValue = "15.0") double baseTemp) {
        return List.of(
                baseTemp,
                baseTemp + 1.5,
                baseTemp + 2.8,
                baseTemp - 0.4,
                baseTemp - 2.1,
                baseTemp + 0.9,
                baseTemp + 3.2
        );
    }
}