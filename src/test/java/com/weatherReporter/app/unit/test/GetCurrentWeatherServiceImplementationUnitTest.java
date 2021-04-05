/*
package com.weatherReporter.app.unit.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.weatherReporter.app.service.GetWeatherFromExternalClientImplementation;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class GetCurrentWeatherServiceImplementationUnitTest {

	@Tested
    GetWeatherFromExternalClientImplementation getCurrentWeatherServiceImplementation;

	@Injectable
	ExternalAPIRequest externalAPIRequest;

	@Test
	public void ShouldGetBackTheClimateReportOfTheCityWhenHitWithCityName() throws IOException, ParseException {

		String externalOutput = "{\"location\": {\"name\": \"Berlin\",\"region\": \"Berlin\",\"country\": \"Germany\"},"
				+ "              \"current\": {\"temp_c\": 14,\"temp_f\": 57.2,\"is_day\": 1,\"condition\": {\"text\": \"Sunny\"},"
				+ "              \"wind_mph\": 9.4,\"wind_kph\": 15.1,\"humidity\": 77}}";
		Map<String, Object> externalAPIresponse = new HashMap<>();
		externalAPIresponse.put("responseCode", 200);
		externalAPIresponse.put("responseMessage", externalOutput);
		new Expectations() {
			{
				externalAPIRequest.makeGETAPIRequest((String) any);
				returns(externalAPIresponse);
			}
		};

		assertEquals(getCurrentWeatherServiceImplementation.getCurrentReport("Berlin").get("responseCode"), 200);
	}

	@Test
	public void ShouldGetBackTheErrorReportWhenHitWithCityNameAndCityNameNotValid() throws IOException, ParseException {

		String externalOutput ="{\"error\": {\"code\": 1006,\"message\": \"No matching location found.\"}}";
		Map<String, Object> externalAPIresponse = new HashMap<>();
		externalAPIresponse.put("responseCode", 400);
		externalAPIresponse.put("responseMessage", externalOutput);
		new Expectations() {
			{
				externalAPIRequest.makeGETAPIRequest((String) any);
				returns(externalAPIresponse);
			}
		};

		assertEquals(getCurrentWeatherServiceImplementation.getCurrentReport("ABCx").get("responseCode"), 400);
	}
}
*/
