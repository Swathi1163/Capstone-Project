package com.capstone.flatbookingdata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.flatbookingdata.modal.Flat;

@FeignClient(name="FLAT-DATA")
public interface FlatServiceConsumer {
	
	@GetMapping("/flat/{id}")
	Flat getFlatById(@PathVariable("id") int flatNo);
	
}
