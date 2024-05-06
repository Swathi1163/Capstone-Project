package com.capstone.flatbookingdata.exception;

@SuppressWarnings("serial")
public class FlatBookingNotFoundException extends RuntimeException {
	
	public FlatBookingNotFoundException() {
		
	}
	
	public FlatBookingNotFoundException(String msg) {
		super(msg);
	}

}
