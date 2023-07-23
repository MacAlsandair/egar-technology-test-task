package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandAndModel(String brand, String model);
    Optional<Vehicle> findByStateNumber(String stateNumber);
}
