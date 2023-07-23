package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Truck extends Vehicle {
	
	@Transient
	private final String vehicleType = "Грузовик";

	@Override
    @Column(name = "vehicle_type")
	public String getVehicleType() {
		return vehicleType;
	}

	public Truck() {
		super();
	}

	public Truck(String brand, String model, String category, String stateNumber, int yearOfManufacture,
			boolean hasTrailer) {
		super(brand, model, category, stateNumber, yearOfManufacture, hasTrailer);
	}

	public Truck(VehicleDTO vehicleDTO) {
		super(vehicleDTO);
	}

}
