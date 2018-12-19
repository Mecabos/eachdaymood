package com.bacemprog.eachdaymood;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class EachdaymoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(EachdaymoodApplication.class, args);
	}

}

