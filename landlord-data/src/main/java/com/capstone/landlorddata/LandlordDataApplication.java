package com.capstone.landlorddata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LandlordDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandlordDataApplication.class, args);
	}

}
