package com.capstone.flatbookingdata.service;

import java.util.List;

import com.capstone.flatbookingdata.entity.FlatBooking;
import com.capstone.flatbookingdata.modal.Flat;
import com.capstone.flatbookingdata.modal.Tenant;

public interface FlatBookingService {

	FlatBooking saveFlatBooking(FlatBooking flatBooking);
    
	FlatBooking getBookingDetailsById(int bookingId);
    
    List<FlatBooking> getAllBooking();
    
    void deleteBooking(int bookingId);

	Flat getFlatData(int flatId);

	Tenant getTenantData(int tenantId); 
     
	void acceptBooking(int bookingId);

    void denyBooking(int bookingId);
    
    String viewBookingStatus(int bookingId);
	
}
