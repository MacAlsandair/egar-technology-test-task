package com.macalsandair.egartechnology.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.addVehicle(vehicleDTO);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable Long id) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleDTO, id);
        return ResponseEntity.ok(updatedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(@RequestBody VehicleDTO vehicleDTO) {
        List<Vehicle> vehicles = vehicleService.searchVehicles(vehicleDTO);
        return ResponseEntity.ok(vehicles);
    }
}
