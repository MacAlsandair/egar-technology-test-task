package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Bus extends Vehicle {
	
	@Transient
	private final String vehicleType = "Автобус";

	@Override
    @Column(name = "vehicle_type")
	public String getVehicleType() {
		return vehicleType;
	}

	public Bus() {
		super();
	}

	public Bus(String brand, String model, String category, String stateNumber, int yearOfManufacture,
			boolean hasTrailer) {
		super(brand, model, category, stateNumber, yearOfManufacture, hasTrailer);
	}

	public Bus(VehicleDTO vehicleDTO) {
		super(vehicleDTO);
	}

	
	
}
