package com.capstone.flatbookingdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.flatbookingdata.entity.FlatBooking;


public interface FlatBookingRepository extends JpaRepository<FlatBooking,Integer>{

}

