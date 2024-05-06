package com.capstone.flatbookingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class FlatbookingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatbookingDataApplication.class, args);
	}

}