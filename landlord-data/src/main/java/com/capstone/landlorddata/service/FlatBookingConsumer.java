package com.capstone.landlorddata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capstone.landlorddata.model.FlatBooking;

@FeignClient(name = "FLATBOOKING-DATA")
public interface FlatBookingConsumer {
    
    @PostMapping("/flatbookingdata/accept/{id}")
    FlatBooking acceptBooking(@PathVariable("id") int bookingId);
    
    @PostMapping("/flatbookingdata/deny/{id}")
    FlatBooking denyBooking(@PathVariable("id") int bookingId);
    
}