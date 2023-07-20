package com.macalsandair.egartechnology.vehicle;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
		switch (vehicleDTO.getVehicleType()) {
		case "car":
			break;
		}
		return null;
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO vehicleDTO, String stateNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleDTO> searchVehicles(String make, String model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isVehicleAlreadyExist (int stateNumber) {
		return true;
	}
	
	

}
