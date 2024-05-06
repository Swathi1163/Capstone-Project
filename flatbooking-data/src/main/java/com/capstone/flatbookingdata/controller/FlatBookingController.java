package com.capstone.flatbookingdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.flatbookingdata.entity.FlatBooking;
import com.capstone.flatbookingdata.modal.Flat;
import com.capstone.flatbookingdata.modal.Tenant;
import com.capstone.flatbookingdata.service.FlatBookingService;


@RestController
@RequestMapping("/flatbookingdata")
public class FlatBookingController {

	@Autowired
	private FlatBookingService fbookingService;

	@PostMapping("/request")
	public ResponseEntity<FlatBooking> requestflatBooking(@RequestBody FlatBooking flatBooking) {

		FlatBooking newFBooking = fbookingService.saveFlatBooking(flatBooking);
		return new ResponseEntity<>(newFBooking, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlatBooking> fetchBookingDetails(@PathVariable("id") int bookingId) {
		FlatBooking fbooking = fbookingService.getBookingDetailsById(bookingId);
		return new ResponseEntity<>(fbooking, HttpStatus.OK);
	}

	@GetMapping("/all")

	public List<FlatBooking> getAllBookings() {

		List<FlatBooking> fBookingList = fbookingService.getAllBooking();
		return fBookingList;
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> deleteBooking(@PathVariable("id") int bookingId) {
		fbookingService.deleteBooking(bookingId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/accept/{id}")
	public ResponseEntity<Void> acceptBooking(@PathVariable("id") int bookingId) {
		fbookingService.acceptBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/deny/{id}")
	public ResponseEntity<Void> denyBooking(@PathVariable("id") int bookingId) {
		fbookingService.denyBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/flat/{id}")
	public ResponseEntity<Flat> getFlatData(@PathVariable("id") int flatId) {
		Flat flat = fbookingService.getFlatData(flatId);
		return new ResponseEntity<>(flat, HttpStatus.OK);
	}

	@GetMapping("/tenantdata/viewtenant/{tenantId}")
	public ResponseEntity<Tenant> getTenantData(@PathVariable("tenantId") int tenantId) {
		Tenant tenant = fbookingService.getTenantData(tenantId);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}
	
	@GetMapping("/status/{id}")
	public ResponseEntity<String> viewBookingStatus(@PathVariable("id") int bookingId) {
	    String bookingStatus = fbookingService.viewBookingStatus(bookingId);
	    return new ResponseEntity<>(bookingStatus, HttpStatus.OK);
	}

}
