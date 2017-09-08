package com.weatherReporter.app.utility;

import static com.weatherReporter.app.utility.Constants.RESPONSECODE;
import static com.weatherReporter.app.utility.Constants.RESPONSEMESSAGE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalAPIRequestImplementation.
 */
@Service
public class ExternalAPIRequestImplementation implements ExternalAPIRequest {

	/** The logger. */
	Logger LOGGER = Logger.getLogger(ExternalAPIRequestImplementation.class);

	/* (non-Javadoc)
	 * @see com.weatherReporter.app.utility.ExternalAPIRequest#makeGETAPIRequest(java.lang.String)
	 */
	@Override
	public Map<String, Object> makeGETAPIRequest(String url) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer response = null;
		URL currentUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) currentUrl.openConnection();
		int responseCode = con.getResponseCode();
		resultMap.put(RESPONSECODE, responseCode);
		LOGGER.info("ResponseCode:" + responseCode);
		BufferedReader bufferedReader = null;
		try {
			if (responseCode < con.HTTP_BAD_REQUEST) {
				bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				response = readResponse(bufferedReader);
				resultMap.put(RESPONSEMESSAGE, response.toString());
			} else {
				bufferedReader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				response = readResponse(bufferedReader);
				resultMap.put(RESPONSEMESSAGE, response.toString());
			}

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		} finally {
			bufferedReader.close();
		}

		return resultMap;

	}

	/**
	 * Read response.
	 *
	 * @param in the in
	 * @return the string buffer
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private StringBuffer readResponse(BufferedReader in) throws IOException {
		StringBuffer response;
		String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		return response;
	}
}
