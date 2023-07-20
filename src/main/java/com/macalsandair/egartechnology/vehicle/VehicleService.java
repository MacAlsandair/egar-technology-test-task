package com.macalsandair.egartechnology.vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDTO addVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO, Long id);
    List<VehicleDTO> searchVehicles(String brand, String model);
}