package com.macalsandair.egartechnology.vehicle;

public class Bus extends Vehicle {

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
