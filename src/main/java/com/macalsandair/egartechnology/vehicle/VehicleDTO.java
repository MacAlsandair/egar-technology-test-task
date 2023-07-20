package com.macalsandair.egartechnology.vehicle;

public class VehicleDTO {

    private String brand;
    private String model;
    private String category;
    private String stateNumber;
    private String vehicleType;
    private int yearOfManufacture;
    private boolean hasTrailer;
    
    
    
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStateNumber() {
		return stateNumber;
	}
	public void setStateNumber(String stateNumber) {
		this.stateNumber = stateNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public boolean isHasTrailer() {
		return hasTrailer;
	}
	public void setHasTrailer(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
    
    
}
