package com.centennial.springboot.demoapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Demoapp2SBootApplication {
	@ResponseBody
	@RequestMapping("/")
	public String home()
	{
		return "Welcome to Spring Boot";
	}

	public static void main(String[] args) {
		SpringApplication.run(Demoapp2SBootApplication.class, args);
		System.out.println("Spring Boot App Started");
	}

}
