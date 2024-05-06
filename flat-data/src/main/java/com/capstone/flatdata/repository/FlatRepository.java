package com.capstone.flatdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.flatdata.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat,Integer>{


	List<Flat> findByCost(float flatCost);


}