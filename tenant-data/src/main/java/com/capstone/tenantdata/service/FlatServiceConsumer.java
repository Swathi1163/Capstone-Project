package com.capstone.tenantdata.service;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.tenantdata.model.Flat;

	@FeignClient(name="FLAT-DATA")
	public interface FlatServiceConsumer {
		
		@GetMapping("/flat/all")
		List<Flat> viewAllAvailableFlats();

	}


