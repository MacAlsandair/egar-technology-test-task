package com.macalsandair.egartechnology.vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDTO addVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO,String stateNumber);
    List<VehicleDTO> searchVehicles(String make, String model);
}