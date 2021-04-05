package com.weatherReporter.app.model;

import lombok.Data;

@Data
public class Error {

	private int code;
	private String type;
	private String info;


}
