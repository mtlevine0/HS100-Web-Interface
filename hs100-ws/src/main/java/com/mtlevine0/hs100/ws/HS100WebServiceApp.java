package com.mtlevine0.hs100.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class HS100WebServiceApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HS100WebServiceApp.class, args);
		System.out.println("HS100 WebService is running!");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HS100WebServiceApp.class);
	}

}
