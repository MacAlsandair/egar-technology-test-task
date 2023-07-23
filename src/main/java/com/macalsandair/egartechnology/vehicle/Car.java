package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Car extends Vehicle {
	
	@Transient
	private final String vehicleType = "Легковой автомобиль";

	@Override
    @Column(name = "vehicle_type")
	public String getVehicleType() {
		return vehicleType;
	}

	public Car() {
		super();
	}

	public Car(String brand, String model, String category, String stateNumber, int yearOfManufacture,
			boolean hasTrailer) {
		super(brand, model, category, stateNumber, yearOfManufacture, hasTrailer);
	}

	public Car(VehicleDTO vehicleDTO) {
		super(vehicleDTO);
	}

}
