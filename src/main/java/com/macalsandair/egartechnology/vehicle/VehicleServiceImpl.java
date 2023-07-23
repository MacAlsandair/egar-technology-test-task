package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(VehicleDTO vehicleDTO) {
		if (!isVehicleAlreadyExist(vehicleDTO.getStateNumber())) {
			Vehicle createdVehicle = createVehicle(vehicleDTO);
			return vehicleRepository.save(createdVehicle);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Этот государственный номер уже есть в системе");
		}
	}

	private Vehicle createVehicle(VehicleDTO vehicleDTO) {
		switch (vehicleDTO.getVehicleType()) {
		case "car":
			Car newCar = new Car(vehicleDTO);
			return newCar;
		case "truck":
			Truck newTruck = new Truck(vehicleDTO);
			return newTruck;
		case "bus":
			Bus newBus = new Bus(vehicleDTO);
			return newBus;
		default:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Запрос некорректен. Такого типа ТС не может быть в системе");
		}
	}

	@Override
	public Vehicle updateVehicle(VehicleDTO vehicleDTO, Long id) {
		if (vehicleRepository.findById(id).isPresent()) {
			Vehicle updatedVehicle = createVehicle(vehicleDTO);
			updatedVehicle.setId(id);
			return vehicleRepository.save(updatedVehicle);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не существует тс с таким id");
		}
	}

//	@Override
//    public List<Vehicle> searchVehicles(VehicleSearchCriteria vehicleSearchCriteria) {
//        return vehicleRepository.search(vehicleSearchCriteria);
//    }

	private boolean isVehicleAlreadyExist(String stateNumber) {
		if (vehicleRepository.findByStateNumber(stateNumber).isPresent()) {
			return true;
		} else
			return false;
	}

//	public List<Vehicle> searchVehicles(VehicleSearchCriteria searchCriteria) {
//		  // Extract search criteria from the VehicleSearchCriteria object
//		  String brand = searchCriteria.getBrand();
//		  String model = searchCriteria.getModel();
//		  String category = searchCriteria.getCategory();
//		  String stateNumber = searchCriteria.getStateNumber();
//		  String vehicleType = searchCriteria.getVehicleType();
//		  Integer yearOfManufacture = searchCriteria.getYearOfManufacture();
//		  Boolean hasTrailer = searchCriteria.getHasTrailer();
//
//		  // Implement search logic using Spring Data JPA
//		  if (yearOfManufacture != null && hasTrailer != null) {
//		    // User passed both parameters
//		    return vehicleRepository.findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndYearOfManufactureAndHasTrailer(
//		            brand, model, category, stateNumber, vehicleType, yearOfManufacture, hasTrailer);
//		  } else if (yearOfManufacture != null) {
//		    // User passed only yearOfManufacture parameter
//		    return vehicleRepository.findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndYearOfManufacture(
//		            brand, model, category, stateNumber, vehicleType, yearOfManufacture);
//		  } else if (hasTrailer != null) {
//		    // User passed only hasTrailer parameter
//		    return vehicleRepository.findByBrandAndModelAndCategoryAndStateNumberAndVehicleTypeAndHasTrailer(
//		            brand, model, category, stateNumber, vehicleType, hasTrailer);
//		  } else {
//		    // User did not pass any of the parameters
//		    return vehicleRepository.findByBrandAndModelAndCategoryAndStateNumberAndVehicleType(
//		            brand, model, category, stateNumber, vehicleType);
//		  }
//		}

	public List<Vehicle> searchVehicles(VehicleSearchCriteria searchCriteria) {
		List<Vehicle> allVehicles = vehicleRepository.findAll();

		return allVehicles.stream().filter(vehicle -> isMatch(vehicle, searchCriteria)).collect(Collectors.toList());
	}

	private boolean isMatch(Vehicle vehicle, VehicleSearchCriteria searchCriteria) {
		// Perform filtering based on each search criteria
		if (searchCriteria.getBrand() != null 
				&& !vehicle.getBrand().equals(searchCriteria.getBrand())) {
			return false;
		}
		if (searchCriteria.getModel() != null 
				&& !vehicle.getModel().equals(searchCriteria.getModel())) {
			return false;
		}
		if (searchCriteria.getCategory() != null 
				&& !vehicle.getCategory().equals(searchCriteria.getCategory())) {
			return false;
		}
		if (searchCriteria.getStateNumber() != null
				&& !vehicle.getStateNumber().equals(searchCriteria.getStateNumber())) {
			return false;
		}
		if (searchCriteria.getVehicleType() != null
				&& !vehicle.getVehicleType().equals(searchCriteria.getVehicleType())) {
			return false;
		}
		if (searchCriteria.getYearOfManufacture() != null
				&& vehicle.getYearOfManufacture() != searchCriteria.getYearOfManufacture().intValue()) {
			return false;
		}
		if (searchCriteria.getHasTrailer() != null
				&& vehicle.isHasTrailer() != searchCriteria.getHasTrailer().booleanValue()) {
			return false;
		}

		return true;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}

	public Vehicle getVehicleById(Long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (vehicle.isPresent()) {
			return vehicle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет транспортного средства с таким id");
		}
	}

}
