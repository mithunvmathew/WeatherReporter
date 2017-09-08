package com.weatherReporter.app;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class WebConfig.
 */
@Configuration
public class WebConfig {

	/**
	 * Authentication filter registration bean.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean authenticationFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		registrationBean.setFilter(authenticationFilter);
		registrationBean.setOrder(1);
		return registrationBean;
	}

}
