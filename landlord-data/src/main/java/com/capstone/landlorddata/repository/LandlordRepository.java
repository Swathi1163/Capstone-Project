package com.capstone.landlorddata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.landlorddata.entity.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
    Landlord findByLandlordId(int landlordId);
}