package com.weatherReporter.app.model;

public class CurrentWeather {
	
	String placeName;
	String country;
	Float temperature_c;
	String condition;
	Float wind_kmph;
	Float humidity;
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Float getTemperature_c() {
		return temperature_c;
	}
	public void setTemperature_c(Float temperature_c) {
		this.temperature_c = temperature_c;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Float getWind_kmph() {
		return wind_kmph;
	}
	public void setWind_kmph(Float wind_kmph) {
		this.wind_kmph = wind_kmph;
	}
	public Float getHumidity() {
		return humidity;
	}
	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}
	
	
	
	
}
