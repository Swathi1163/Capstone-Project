package com.capstone.landlorddata.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.landlorddata.model.Flat;

@FeignClient(name = "FLAT-DATA")


public interface FlatServiceConsumer {
	
	    @GetMapping("/flat/{id}")
	    Flat getFlatDetails(@PathVariable("id") int flatId);
	    
	    @PostMapping("/flat/save")
	    Flat saveFlat(@RequestBody Flat flat);
	    
	    @DeleteMapping("/flat/delete/{id}")
	    void deleteFlat(@PathVariable("id") int flatId);
	    
	    @GetMapping("/flat/all")
	    List<Flat> viewAllFlats();


	}


    