package com.ibm.mybatis.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MybatisApplication {

	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
