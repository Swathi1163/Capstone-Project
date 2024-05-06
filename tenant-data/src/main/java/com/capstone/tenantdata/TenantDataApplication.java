package com.capstone.tenantdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients 
@SpringBootApplication
public class TenantDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantDataApplication.class, args);
	}

}
