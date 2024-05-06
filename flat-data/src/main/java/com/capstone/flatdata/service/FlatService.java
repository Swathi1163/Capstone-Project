package com.capstone.flatdata.service;

import java.util.List;

import com.capstone.flatdata.entity.Flat;

public interface FlatService {

	Flat saveFlat(Flat flat);

	Flat updateFlat(Flat flat);

	void deleteFlatById(int flatId);

	Flat viewFlatById(int flatId);

	List<Flat> viewAllFlats();

	List<Flat> viewAllFlatsByCost(float cost);
}