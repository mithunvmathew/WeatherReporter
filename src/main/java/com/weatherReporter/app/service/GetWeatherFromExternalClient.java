package com.weatherReporter.app.service;

import com.weatherReporter.app.model.WeatherResponse;

/**
 * The Interface GetCurrentWeatherService.
 */
public interface GetWeatherFromExternalClient {

	/**
	 * Gets the current report.
	 *
	 * @param city the city
	 * @return the current report
	 */
	 WeatherResponse getCurrentReport(String city) ;

}
