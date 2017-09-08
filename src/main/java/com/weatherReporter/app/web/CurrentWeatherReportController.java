package com.weatherReporter.app.web;

import static com.weatherReporter.app.utility.Constants.RESPONSECODE;
import static com.weatherReporter.app.utility.Constants.RESPONSEMESSAGE;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherReporter.app.service.GetCurrentWeatherService;

/**
 * The Class CurrentWeatherReportController.
 */
@RestController
@RequestMapping(value = "/wetherNow")
public class CurrentWeatherReportController {

	/** The get current weather service. */
	@Autowired
	GetCurrentWeatherService getCurrentWeatherService;

	/**
	 * Gets the todays waether report.
	 *
	 * @param city the city
	 * @return the todays waether report
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{city}", produces = { "application/json",
			"application/text" })
	public ResponseEntity<Object> getTodaysWaetherReport(@PathVariable String city) throws IOException, ParseException {
		Map<String, Object> result = getCurrentWeatherService.getCurrentReport(city);
		return ResponseEntity.status((int) result.get(RESPONSECODE)).body(result.get(RESPONSEMESSAGE));

	}

}
