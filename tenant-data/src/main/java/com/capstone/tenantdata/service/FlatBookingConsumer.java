package com.capstone.tenantdata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.tenantdata.model.FlatBooking;


@FeignClient(name = "FLATBOOKING-DATA")
public interface FlatBookingConsumer {
	
	@PostMapping("/flatbookingdata/request")
	FlatBooking addBooking(@RequestBody FlatBooking flatBooking);
	
	@GetMapping("/flatbookingdata/status/{id}")
	String viewBookingStatus(@PathVariable("id") int bookingId)	;

}