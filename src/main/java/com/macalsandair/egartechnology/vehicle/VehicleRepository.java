package com.macalsandair.egartechnology.vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandAndModel(String brand, String model);
    Vehicle findByStateNumber(String stateNumber);
}