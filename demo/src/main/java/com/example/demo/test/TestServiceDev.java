package com.example.demo.test;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")

public class TestServiceDev implements TestService{

		public String getString(){
			return "NONE ==> Dev ====> NONE";
		}
}
