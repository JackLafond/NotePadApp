package com.intactinsurance.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@ComponentScan(basePackages={"com.intactinsurance.restdemo"})
@EntityScan("com.intactinsurance.restdemo")
@EnableAutoConfiguration
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

}
