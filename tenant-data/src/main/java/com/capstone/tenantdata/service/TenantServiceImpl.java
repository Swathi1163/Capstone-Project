package com.capstone.tenantdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.tenantdata.entity.Tenant;
import com.capstone.tenantdata.exception.TenantNotFoundException;
import com.capstone.tenantdata.model.Flat;
import com.capstone.tenantdata.model.FlatBooking;
import com.capstone.tenantdata.repository.TenantRepository;


@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantRepository tenantRepository;
    
    @Autowired
    private FlatServiceConsumer flatService;
    
    @Autowired
    private FlatBookingConsumer bookingService;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        tenantRepository.save(tenant);
        return tenant;
    }

    @Override
    public Tenant updateTenant(Tenant tenant) {
    	Optional<Tenant> optionalTenant = tenantRepository.findById(tenant.getTenantId());
		if(optionalTenant.isEmpty()) {
			
			
			throw new TenantNotFoundException("Tenant not existing with id: "+ tenant.getTenantId());
		}
		
		tenantRepository.save(tenant);		
		return tenant;
	}


    @Override
    public void deleteTenantById(int tenantId) {
    	Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isEmpty()) {			
			
			throw new TenantNotFoundException("Tenant not existing with id: "+tenantId);
			
		}
		Tenant tenant = optionalTenant.get();
		tenantRepository.delete(tenant);		
		
	}
    @Override
    public Tenant viewTenantById(int tenantId) {
    	Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: "+tenantId);
			
		}
		Tenant tenant = optionalTenant.get();
		return tenant;

			}
    @Override
    public List<Tenant> viewAllTenants() {
    	List<Tenant> tenants= tenantRepository.findAll();
		return tenants;
	}

	@Override
	public List<Flat> viewAllFlats() {
		List<Flat> flats = flatService.viewAllAvailableFlats();
		return flats;
	}

	@Override
	public FlatBooking addBooking(FlatBooking flatBooking) {
		FlatBooking flat = bookingService.addBooking(flatBooking);
		return flat;
	}

	@Override
	public String viewBookingStatus(int bookingId) {
		String bookingStatus= bookingService.viewBookingStatus(bookingId);
		return bookingStatus;
	}
}