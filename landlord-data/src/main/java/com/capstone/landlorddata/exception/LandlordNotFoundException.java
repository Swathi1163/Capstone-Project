package com.capstone.landlorddata.exception;

@SuppressWarnings("serial")
public class LandlordNotFoundException extends RuntimeException {
	
	public LandlordNotFoundException() {
		
	}
	
	public LandlordNotFoundException(String msg) {
		super(msg);
	}

}