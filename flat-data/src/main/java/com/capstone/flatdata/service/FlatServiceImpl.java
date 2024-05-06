package com.capstone.flatdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.flatdata.entity.Flat;
import com.capstone.flatdata.exception.FlatNotFoundException;
import com.capstone.flatdata.repository.FlatRepository;


@Service
public class FlatServiceImpl implements FlatService {
	
	@Autowired 
	private FlatRepository flatRepository;

	@Override
	public Flat saveFlat(Flat flat) {
		flatRepository.save(flat);
		return flat;
		
	}

	@Override
	public Flat updateFlat(Flat flat) {
		Optional<Flat> optionalFlat = flatRepository.findById(flat.getFlatId());
		if(optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id: "+ flat.getFlatId());
		}
		
		flatRepository.save(flat);		
		return flat;
	}

	@Override
	public void deleteFlatById(int flatId) {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flatnot existing with id: "+flatId);
			
		}
		Flat flat = optionalFlat.get();
		flatRepository.delete(flat);		
		
	}

	@Override
	public Flat viewFlatById(int flatId) {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id: "+flatId);
			
		}
		Flat flat = optionalFlat.get();
		return flat;

			}

	@Override
	public List<Flat> viewAllFlats() {
		List<Flat> flats = flatRepository.findAll();
		return flats;
	}

	@Override
    public List<Flat> viewAllFlatsByCost(float flatCost) {
        return flatRepository.findByCost(flatCost);
    }

}