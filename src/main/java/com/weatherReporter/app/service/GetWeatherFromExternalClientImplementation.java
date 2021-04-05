package com.weatherReporter.app.service;

import com.weatherReporter.app.exception.ExternalServiceException;
import com.weatherReporter.app.model.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.weatherReporter.app.utility.Constants.APIKEYOPEARTOR;
import static com.weatherReporter.app.utility.Constants.CONNECTOR;

/**
 * The Class GetCurrentWeatherServiceImplementation.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GetWeatherFromExternalClientImplementation implements GetWeatherFromExternalClient {

    private final RestTemplate restTemplate;
    /**
     * The external url.
     */
    @Value("${weatherstack.url}")
    private String externalUrl;

    /**
     * The key.
     */
    @Value("${weatherstack.key}")
    private String key;

    @Override
    public WeatherResponse getCurrentReport(String city) {
        try {
            String url = externalUrl + APIKEYOPEARTOR + key + CONNECTOR + city;
            log.info("External URL:" + url);
            return restTemplate.getForEntity(url, WeatherResponse.class).getBody();
        } catch (Exception ex) {
            throw new ExternalServiceException("External service not responsing", ex);
        }
    }
}
