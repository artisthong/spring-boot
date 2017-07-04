package com.example.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private TestService testService;
	

	public TestController(TestService testService) {
		super();
		this.testService = testService;
	}

	
	/**
	 * constructor
	 * @return
	 */
	@RequestMapping("/test/string")
	public String testString(){
		
		return testService.getString();
	}
	
//	public String getTestService(){
//		
//	}
}
