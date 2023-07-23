package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandAndModel(String brand, String model);
    Optional<Vehicle> findByStateNumber(String stateNumber);
    //List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(String brand, String model);
    //List<Vehicle> findByField(String brand, String model);
    
    List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(
            String brand, String model, String category, String stateNumber, int yearOfManufacture,
            boolean hasTrailer);
    
    default List<Vehicle> search(VehicleDTO vehicleDTO) {
        return findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(
                vehicleDTO.getBrand(), vehicleDTO.getModel(), vehicleDTO.getCategory(), vehicleDTO.getStateNumber(),
                vehicleDTO.getYearOfManufacture(), vehicleDTO.isHasTrailer());
    }
    
}
