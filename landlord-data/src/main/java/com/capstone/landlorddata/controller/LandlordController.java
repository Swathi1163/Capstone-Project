package com.capstone.landlorddata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.landlorddata.entity.Landlord;
import com.capstone.landlorddata.model.Flat;
import com.capstone.landlorddata.model.FlatBooking;
import com.capstone.landlorddata.model.Tenant;
import com.capstone.landlorddata.service.LandlordService;

@RestController
@RequestMapping("/landlorddata")
public class LandlordController {
	@Autowired
	private LandlordService landlordService;

	@GetMapping("/all")
	public List<Landlord> fetchAllLandlords() {
		List<Landlord> landlords = landlordService.viewAllLandlords();
		return landlords;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Landlord> fetchLandlordDetails(@PathVariable("id") int landlordId) {
		Landlord landlord = landlordService.viewLandlord(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Landlord> addLandlord(@RequestBody Landlord landlord) {
		landlordService.saveLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(landlord, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Landlord> editLandlord(@RequestBody Landlord landlord) {
		landlordService.updateLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(landlord, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLandlord(@PathVariable("id") int landlordId) {
		landlordService.deleteLandlordById(landlordId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/flat/save")
	public ResponseEntity<Flat> saveFlat(@RequestBody Flat flat) {
		landlordService.saveFlat(flat);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(flat, HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/flat/delete/{id}")
	public ResponseEntity<Void> deleteFlat(@PathVariable("id") int flatId) {
		landlordService.deleteFlat(flatId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/flat/all")
	public List<Flat> viewAllFlats() {
		List<Flat> flats = landlordService.viewAllFlats();
		return flats;
	}

	@GetMapping("/tenantdata/viewtenant/{tenantId}")
	public ResponseEntity<Tenant> viewTenantById(@PathVariable("tenantId") int tenantId) {
		Tenant tenant = landlordService.viewTenantById(tenantId);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}

	@PostMapping("/flatbookingdata/accept/{id}")
	public ResponseEntity<FlatBooking> acceptBooking(@PathVariable("id") int bookingId) {
		landlordService.acceptBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/flatbookingdata/deny/{id}")
	public ResponseEntity<FlatBooking> denyBooking(@PathVariable("id") int bookingId) {
		landlordService.denyBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

}