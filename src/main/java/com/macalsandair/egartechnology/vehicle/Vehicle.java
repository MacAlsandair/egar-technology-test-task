package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String category;
    private String stateNumber;
    private int yearOfManufacture;
    private boolean hasTrailer;
    
    
	public Vehicle() {
		super();
	}
	
	public Vehicle(String brand, String model, String category, String stateNumber, int yearOfManufacture,
			boolean hasTrailer) {
		super();
		this.brand = brand;
		this.model = model;
		this.category = category;
		this.stateNumber = stateNumber;
		this.yearOfManufacture = yearOfManufacture;
		this.hasTrailer = hasTrailer;
	}    
	
	public Vehicle(VehicleDTO vehicleDTO) {
		super();
		this.brand = vehicleDTO.getBrand();
		this.model = vehicleDTO.getModel();
		this.category = vehicleDTO.getCategory();
		this.stateNumber = vehicleDTO.getStateNumber();
		this.yearOfManufacture = vehicleDTO.getYearOfManufacture();
		this.hasTrailer = vehicleDTO.isHasTrailer();
	}    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
