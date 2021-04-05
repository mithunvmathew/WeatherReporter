/*
package com.weatherReporter.app.unit.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class ExternalAPIRequestImplementationUnitTest {

	@Tested
	ExternalAPIRequestImplementation externalAPIRequestImplementation;

	@Mocked
	URL currentUrl;

	@Mocked
	HttpURLConnection con;

	@Mocked
	BufferedReader bufferedReader;

	@Mocked
	InputStreamReader inputStreamReader;

	@Mocked
	InputStream inputStream;

	@Test
	public void ShouldGetInputStreamOfaGETRequestWithSuccessMessage() throws IOException {

		String url = "http://api.apixu.com/v1/current.json?key=12345&q=Berlin";

		new Expectations() {
			{
				new URL(url);

				currentUrl.openConnection();
				returns(con);

				con.getResponseCode();
				returns(200);

				con.getInputStream();
				returns(inputStream);

				new BufferedReader(new InputStreamReader(inputStream));
				returns(bufferedReader);

				bufferedReader.readLine();

				bufferedReader.close();
			}
		};

		assertEquals(externalAPIRequestImplementation.makeGETAPIRequest(url).get("responseCode"), 200);
	}
	
	@Test
	public void ShouldGetErrorStreamOfaGETRequestWithErrorMessage() throws IOException {

		String url = "http://api.apixu.com/v1/current.json?key=12345&q=Berlin";

		new Expectations() {
			{
				new URL(url);

				currentUrl.openConnection();
				returns(con);

				con.getResponseCode();
				returns(400);

				con.getErrorStream();
				returns(inputStream);

				new BufferedReader(new InputStreamReader(inputStream));
				returns(bufferedReader);

				bufferedReader.readLine();

				bufferedReader.close();
			}
		};

		assertEquals(externalAPIRequestImplementation.makeGETAPIRequest(url).get("responseCode"), 400);
	}

}
*/
