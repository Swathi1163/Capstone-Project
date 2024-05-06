 package com.capstone.tenantdata.service;

import java.util.List;

import com.capstone.tenantdata.entity.Tenant;
import com.capstone.tenantdata.model.Flat;
import com.capstone.tenantdata.model.FlatBooking;

public interface TenantService {
	
	Tenant saveTenant(Tenant tenant);

	Tenant updateTenant(Tenant tenant);

	void deleteTenantById(int tenantId);

	Tenant viewTenantById(int tenantId);

	List<Tenant> viewAllTenants();
	
	List<Flat> viewAllFlats();
	
	FlatBooking addBooking(FlatBooking flatBooking);
	
	String viewBookingStatus(int bookingId);
}
