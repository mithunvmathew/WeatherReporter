package com.weatherReporter.app.web;

import com.weatherReporter.app.model.WeatherResponse;
import com.weatherReporter.app.service.GetWeatherFromExternalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class CurrentWeatherReportController.
 */
@RestController
@RequestMapping(value = "now")
public class CurrentWeatherReportController {

    /**
     * The get current weather service
     */
    @Autowired
    GetWeatherFromExternalClient getCurrentWeatherService;

    /**
     * Gets the todays waether report.
     *
     * @param city the city
     * @return the todays waether report
     */

    @GetMapping(value = "/{city}")
    public WeatherResponse getTodaysWaetherReport(@PathVariable String city) {
        return getCurrentWeatherService.getCurrentReport(city);
    }

}
