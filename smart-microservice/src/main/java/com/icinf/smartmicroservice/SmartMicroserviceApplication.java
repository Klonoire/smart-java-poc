package com.icinf.smartmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SmartMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartMicroserviceApplication.class, args);
	}

}
