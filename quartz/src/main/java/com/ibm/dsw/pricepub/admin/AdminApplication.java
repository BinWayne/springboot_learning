package com.ibm.dsw.pricepub.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ibm.dsw.pricepub.admin"})
@EnableAutoConfiguration
public class AdminApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { AdminApplication.class });
	}


	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
