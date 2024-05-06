package com.capstone.tenantdata.controller;


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

import com.capstone.tenantdata.entity.Tenant;
import com.capstone.tenantdata.model.Flat;
import com.capstone.tenantdata.model.FlatBooking;
import com.capstone.tenantdata.service.TenantService;


@RestController
@RequestMapping("/tenantdata")
public class TenantController {
	@Autowired
    private TenantService tenantService;

    @PostMapping("/save")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
    	tenantService.saveTenant(tenant);
		ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(tenant,HttpStatus.CREATED);
		return responseEntity;
	}
    @PutMapping("/update")
    public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant tenant) {
    	tenantService.updateTenant(tenant);
		ResponseEntity<Tenant> responseEntity= new ResponseEntity<>(tenant, HttpStatus.OK);
		return responseEntity;
	}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable("id") int tenantId) {
    	tenantService.deleteTenantById(tenantId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

    @GetMapping("/viewtenant/{tenantId}")
    public ResponseEntity<Tenant> viewTenant(@PathVariable("tenantId") int tenantId) {
        Tenant tenant= tenantService.viewTenantById(tenantId);
        return new ResponseEntity<>(tenant,HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Tenant> viewAllTenants() {
        List<Tenant> tenants=tenantService.viewAllTenants();
        return tenants;
    }
    @GetMapping("/flat/all")
    public List<Flat> viewAllFlats() {
        List<Flat> flats=tenantService.viewAllFlats();
        return flats;
    }
    
    @PostMapping("/flatbookingdata/request")
    public ResponseEntity<FlatBooking> addBooking(@RequestBody FlatBooking flatBooking) {
    	tenantService.addBooking(flatBooking);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(flatBooking,HttpStatus.CREATED);
		return responseEntity;
	}
    
    @GetMapping("/flatbookingdata/status/{id}")
    public String viewBookingStatus(@PathVariable("id") int bookingId) {    	
    	String bookingStatus = tenantService.viewBookingStatus(bookingId);
		return bookingStatus;
    	
    }
    
}