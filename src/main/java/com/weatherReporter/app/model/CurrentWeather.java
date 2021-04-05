package com.weatherReporter.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeather {
	
	float temperature;
	float windSpeed;
	float humidity;
	int uvIndex;
}
