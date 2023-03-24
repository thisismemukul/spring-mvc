package com.springmvc.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	private int minimum;
	private int maximum;
	

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMinimum() {
		return minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMaximum() {
		return maximum;
	}
	
	

}
