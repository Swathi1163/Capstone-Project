package com.capstone.landlorddata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.landlorddata.entity.Landlord;
import com.capstone.landlorddata.exception.LandlordNotFoundException;
import com.capstone.landlorddata.model.Flat;
import com.capstone.landlorddata.model.Tenant;
import com.capstone.landlorddata.repository.LandlordRepository;

@Service
public class LandlordServiceImpl implements LandlordService {
	
	@Autowired
	private LandlordRepository landlordRepository;
	
	@Autowired
	private FlatServiceConsumer flatService;
	
	@Autowired
	private TenantServiceConsumer tenantService;
	
	@Autowired
	private FlatBookingConsumer bookingService;

	@Override
	public Landlord saveLandlord(Landlord landlord) {
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public Landlord updateLandlord(Landlord landlord) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlord.getLandlordId());
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id "+landlord.getLandlordId()+"does not exist");
		}
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public Landlord viewLandlord(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id "+landlordId+"does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		return landlord;
	}

	@Override
	public List<Landlord> viewAllLandlords() {
		List<Landlord> landlords = landlordRepository.findAll();
		return landlords;
	}

	@Override
	public void deleteLandlordById(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id "+landlordId+"does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		landlordRepository.delete(landlord);

	}

	@Override
	public Flat saveFlat(Flat flat) {
		flatService.saveFlat(flat);
		return flat;
	}

	@Override
	public void deleteFlat(int flatId) {
		flatService.deleteFlat(flatId);
		
	}

	@Override
	public List<Flat> viewAllFlats() {
		List<Flat> flats = flatService.viewAllFlats();
		return flats;
	}

	@Override
	public Tenant viewTenantById(int tenantId) {
		Tenant tenant = tenantService.getTenantDetails(tenantId);
		return tenant;
	}

	@Override
	public void acceptBooking(int bookingId) {
		bookingService.acceptBooking(bookingId);
		
	}

	@Override
	public void denyBooking(int bookingId) {
		bookingService.denyBooking(bookingId);
		
	}
	

}