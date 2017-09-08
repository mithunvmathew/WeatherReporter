package com.weatherReporter.app.utility;

import java.io.IOException;
import java.util.Map;

/**
 * The Interface ExternalAPIRequest.
 */
public interface ExternalAPIRequest {

	/**
	 * Make GETAPI request.
	 *
	 * @param url the url
	 * @return the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Map<String, Object> makeGETAPIRequest(String url) throws IOException;
}
