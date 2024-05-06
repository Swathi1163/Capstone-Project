package com.capstone.landlorddata.service;

import java.util.List;

import com.capstone.landlorddata.entity.Landlord;
import com.capstone.landlorddata.model.Flat;
import com.capstone.landlorddata.model.Tenant;

public interface LandlordService {
	
	Landlord saveLandlord(Landlord landlord);

	Landlord updateLandlord(Landlord landlord);

	void deleteLandlordById(int landlordId);

	Landlord viewLandlord(int landlordId);

	List<Landlord> viewAllLandlords();
	
	Flat saveFlat(Flat flat);
	
	void deleteFlat(int flatId);
	
	List<Flat> viewAllFlats();
	
	Tenant viewTenantById(int tenantId);
	
	void acceptBooking(int bookingId);
	
	void denyBooking(int bookingId);
}