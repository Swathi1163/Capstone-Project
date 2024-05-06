package com.capstone.landlorddata.model;

public class Flat {
	
    private int flatId;
    private float cost;
    private String availability;
    private FlatAddress flatAddress;
    private int landlorddataId;

    
    public int getLandlorddataId() {
		return landlorddataId;
	}

	public void setLandlorddataId(int landlorddataId) {
		this.landlorddataId = landlorddataId;
	}

	public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public FlatAddress getFlatAddress() {
        return flatAddress;
    }

    public void setFlatAddress(FlatAddress flatAddress) {
        this.flatAddress = flatAddress;
    }

}