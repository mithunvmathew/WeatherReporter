package com.weatherReporter.app.unit.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.weatherReporter.app.model.CurrentWeather;
import com.weatherReporter.app.service.GetCurrentWeatherService;
import com.weatherReporter.app.web.CurrentWeatherReportController;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CurrentWeatherReportControllerUnitTest {

	@Tested
	CurrentWeatherReportController currentWeatherReportController;

	@Injectable
	GetCurrentWeatherService getCurrentWeatherService;

	@Test
	public void ShouldReturnOKResponseEnityIfGetCurrentWeatherServiceGivingBackTrue()
			throws IOException, ParseException {

		Map<String, Object> resultMap = new HashMap<>();
		CurrentWeather currentWeather = new CurrentWeather();
		resultMap.put("responseCode", 200);
		resultMap.put("responseMessage", currentWeather);
		ResponseEntity expectedEnity = new ResponseEntity(200, HttpStatus.OK);

		new Expectations() {
			{
				getCurrentWeatherService.getCurrentReport((String) any);
				returns(resultMap);
			}
		};

		assertEquals(currentWeatherReportController.getTodaysWaetherReport("Paris").getStatusCode(),
				expectedEnity.getStatusCode());
	}

}
