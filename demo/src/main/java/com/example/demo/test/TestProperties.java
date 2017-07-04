package com.example.demo.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="test")
public class TestProperties {
	private String env;

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "TestProperties [env=" + env + "]";
	}
	
	
}
