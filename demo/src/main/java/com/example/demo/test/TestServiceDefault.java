package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","prod"})
@EnableConfigurationProperties(TestProperties.class)
public class TestServiceDefault  implements TestService{
	@Value("${test.string:NONE}")
	private String testString;
	
	@Autowired
	private TestProperties props;
	
	public String getString(){
		return testString + "----> "+ props.getEnv();
//		return testString;
//		return "spring-boot-workshop!";
	}
}
