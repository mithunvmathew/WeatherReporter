package com.weatherReporter.app.service;

import static com.weatherReporter.app.utility.Constants.APIKEYOPEARTOR;
import static com.weatherReporter.app.utility.Constants.CONDITION;
import static com.weatherReporter.app.utility.Constants.CONNECTOR;
import static com.weatherReporter.app.utility.Constants.COUNTRY;
import static com.weatherReporter.app.utility.Constants.CURRENT;
import static com.weatherReporter.app.utility.Constants.ERROR;
import static com.weatherReporter.app.utility.Constants.HUMIDITY;
import static com.weatherReporter.app.utility.Constants.LOCATION;
import static com.weatherReporter.app.utility.Constants.MSG;
import static com.weatherReporter.app.utility.Constants.NAME;
import static com.weatherReporter.app.utility.Constants.RESPONSECODE;
import static com.weatherReporter.app.utility.Constants.RESPONSEMESSAGE;
import static com.weatherReporter.app.utility.Constants.TEMP_C;
import static com.weatherReporter.app.utility.Constants.TEXT;
import static com.weatherReporter.app.utility.Constants.WIND_KPH;

import java.io.IOException;
import java.util.Map;

import org.jboss.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.weatherReporter.app.model.CurrentWeather;
import com.weatherReporter.app.utility.ExternalAPIRequest;

/**
 * The Class GetCurrentWeatherServiceImplementation.
 */
@Service
public class GetCurrentWeatherServiceImplementation implements GetCurrentWeatherService {

	/** The logger. */
	Logger LOGGER = Logger.getLogger(GetCurrentWeatherServiceImplementation.class);
	
	/** The external API request. */
	@Autowired
	ExternalAPIRequest externalAPIRequest;

	/** The external url. */
	@Value("${apixu.url}")
	private String externalUrl;

	/** The key. */
	@Value("${apixu.key}")
	private String key;

	/* (non-Javadoc)
	 * @see com.weatherReporter.app.service.GetCurrentWeatherService#getCurrentReport(java.lang.String)
	 */
	@Override
	public Map<String, Object> getCurrentReport(String city) throws IOException, ParseException {

		String url = externalUrl + APIKEYOPEARTOR + key + CONNECTOR + city;
		LOGGER.info("External URL:"+url);
		Map<String, Object> externalAPIresponse = externalAPIRequest.makeGETAPIRequest(url);
		CurrentWeather currentWeather = null;

		if (externalAPIresponse.get(RESPONSECODE).equals(200)) {
			currentWeather = processTheResponseData(externalAPIresponse.get(RESPONSEMESSAGE).toString());
			externalAPIresponse.put(RESPONSEMESSAGE, currentWeather);
		} else {
			String message = processErrorResponse(externalAPIresponse.get(RESPONSEMESSAGE).toString());
			externalAPIresponse.put(RESPONSEMESSAGE, message);
			LOGGER.error(message);
		}
		return externalAPIresponse;

	}

	/**
	 * Process error response.
	 *
	 * @param externalAPIresponse the external AP iresponse
	 * @return the string
	 * @throws ParseException the parse exception
	 */
	private String processErrorResponse(String externalAPIresponse) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(externalAPIresponse);
		JSONObject error = (JSONObject) jsonObject.get(ERROR);
		String message = error.get(MSG).toString();
		return message;
	}

	/**
	 * Process the response data.
	 *
	 * @param externalAPIresponse the external AP iresponse
	 * @return the current weather
	 * @throws ParseException the parse exception
	 */
	private CurrentWeather processTheResponseData(String externalAPIresponse) throws ParseException {
		JSONParser parser = new JSONParser();
		CurrentWeather currentWeather = new CurrentWeather();
		JSONObject jsonObject = (JSONObject) parser.parse(externalAPIresponse);

		JSONObject location = (JSONObject) jsonObject.get(LOCATION);
		JSONObject current = (JSONObject) jsonObject.get(CURRENT);
		currentWeather.setCountry((String) location.get(COUNTRY));
		currentWeather.setPlaceName((String) location.get(NAME));
		currentWeather.setTemperature_c(Float.valueOf(current.get(TEMP_C).toString()));
		currentWeather.setWind_kmph(Float.valueOf(current.get(WIND_KPH).toString()));
		currentWeather.setHumidity(Float.valueOf(current.get(HUMIDITY).toString()));
		JSONObject condition = (JSONObject) current.get(CONDITION);
		currentWeather.setCondition((String) condition.get(TEXT));
		return currentWeather;
	}

}
