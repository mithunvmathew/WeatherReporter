package com.weatherReporter.app.service;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

/**
 * The Interface GetCurrentWeatherService.
 */
public interface GetCurrentWeatherService {

	/**
	 * Gets the current report.
	 *
	 * @param city the city
	 * @return the current report
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	public Map<String, Object> getCurrentReport(String city) throws IOException, ParseException;

}
