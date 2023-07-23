package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandAndModel(String brand, String model);
    Optional<Vehicle> findByStateNumber(String stateNumber);
    //List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(String brand, String model);
    //List<Vehicle> findByField(String brand, String model);
    
//	List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndYearOfManufactureAndHasTrailer(
//			String brand, String model, String category, String stateNumber, String vehicleType,
//			Integer yearOfManufacture, Boolean hasTrailer);
//	
//	List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndYearOfManufacture(String brand,
//			String model, String category, String stateNumber, String vehicleType, Integer yearOfManufacture);
//	
//	List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndHasTrailer(String brand, String model,
//			String category, String stateNumber, String vehicleType, Boolean hasTrailer);
//	
//	List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndVehicleType(String brand, String model,
//			String category, String stateNumber, String vehicleType);
    
//    List<Vehicle> findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(
//            String brand, String model, String category, String stateNumber, int yearOfManufacture,
//            boolean hasTrailer);
//    
//    default List<Vehicle> search(VehicleDTO vehicleSearchCriteria) {
//        return findByBrandAndModelAndCategoryAndStateNumberAndYearOfManufactureAndHasTrailer(
//        		vehicleSearchCriteria.getBrand(), vehicleSearchCriteria.getModel(), vehicleSearchCriteria.getCategory(), vehicleSearchCriteria.getStateNumber(),
//        		vehicleSearchCriteria.getYearOfManufacture(), vehicleSearchCriteria.isHasTrailer());
//    }
    
}
