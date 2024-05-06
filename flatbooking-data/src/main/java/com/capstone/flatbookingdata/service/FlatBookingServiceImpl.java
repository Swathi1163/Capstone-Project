package com.capstone.flatbookingdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.flatbookingdata.entity.FlatBooking;
import com.capstone.flatbookingdata.exception.FlatBookingNotFoundException;
import com.capstone.flatbookingdata.modal.Flat;
import com.capstone.flatbookingdata.modal.Tenant;
import com.capstone.flatbookingdata.repository.FlatBookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class FlatBookingServiceImpl implements FlatBookingService {

    @Autowired
    private FlatBookingRepository flatBookingRepository;

    @Autowired
    private FlatServiceConsumer flatService;

    @Autowired
    private TenantServiceConsumer tenantService;

    @Override
    public FlatBooking saveFlatBooking(FlatBooking flatBooking) {
        flatBooking.setBookingDate(LocalDate.now());
        flatBooking.setBookingStatus("pending");
        flatBooking.setBookingFromDate(LocalDate.of(2024, 05, 06));
        flatBooking.setBookingToDate(LocalDate.of(2025, 07, 17));

        flatBookingRepository.save(flatBooking);
        return flatBooking;
    }

    @Override
    public FlatBooking getBookingDetailsById(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }

        FlatBooking fbooking = optionalBooking.get();
        return fbooking;
    }

    @Override
    public List<FlatBooking> getAllBooking() {
        List<FlatBooking> fBookingList = flatBookingRepository.findAll();
        return fBookingList;
    }

    @Override
    public void deleteBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBookingRepository.delete(flatBooking);
    }
    
    @Override
    public void acceptBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus("booking conformed");
        flatBookingRepository.save(flatBooking);
    }

    @Override
    public void denyBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus(" booking denied");
        flatBookingRepository.save(flatBooking);
        
    }


    public Flat getFlatData(int flatNo) {
        return flatService.getFlatById(flatNo);
    }
   
    public Tenant getTenantData(int tenantId) {
        return tenantService.getTenantData(tenantId);
    }

	@Override
	public String viewBookingStatus(int bookingId) {
		 Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
		    if (optionalBooking.isEmpty()) {
		        throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
		    }
		    FlatBooking flatBooking = optionalBooking.get();
		    return flatBooking.getBookingStatus();
	}
}
