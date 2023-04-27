package com.sample.jsonserializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleJsonSerializerDemoApplication {

	public static void main(String[] args) {
		// Setting profile for dev/prod/default
		/*
		SpringApplication application = 
			      new SpringApplication(SampleJsonSerializerDemoApplication.class);
			    application.setAdditionalProfiles("dev");
		*/
		SpringApplication.run(SampleJsonSerializerDemoApplication.class, args);
		
	}

}
