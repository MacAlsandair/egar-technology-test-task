package com.macalsandair.egartechnology.vehicle;

import java.util.List;

public interface VehicleService {
	List<Vehicle> getAllVehicles();
	Vehicle addVehicle(VehicleDTO vehicleDTO);
    Vehicle updateVehicle(VehicleDTO vehicleDTO, Long id);
    List<Vehicle> searchVehicles(VehicleSearchCriteria vehicleSearchCriteria);
    Vehicle getVehicleById(Long id);
}