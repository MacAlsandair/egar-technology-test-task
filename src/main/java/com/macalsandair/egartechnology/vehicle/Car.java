package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Car extends Vehicle {

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
