package com.macalsandair.egartechnology.vehicle;

import java.util.List;

public interface VehicleService {
	List<Vehicle> getAllVehicles();
	Vehicle addVehicle(VehicleDTO vehicleDTO);
    Vehicle updateVehicle(VehicleDTO vehicleDTO, Long id);
    List<VehicleDTO> searchVehicles(String brand, String model);
    Vehicle getVehicleById(Long id);
}