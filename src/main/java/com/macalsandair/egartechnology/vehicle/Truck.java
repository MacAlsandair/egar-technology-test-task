package com.macalsandair.egartechnology.vehicle;

public class Truck extends Vehicle {

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
