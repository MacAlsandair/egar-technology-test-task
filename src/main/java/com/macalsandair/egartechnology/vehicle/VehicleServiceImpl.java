package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;

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
		}
		else {
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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрос некорректен. Такого типа ТС не может быть в системе");
		}
	}

	@Override
	public Vehicle updateVehicle(VehicleDTO vehicleDTO, Long id) {
		if (vehicleRepository.findById(id).isPresent()) {
			Vehicle updatedVehicle = createVehicle(vehicleDTO);
			updatedVehicle.setId(id);
			return vehicleRepository.save(updatedVehicle);
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не существует тс с таким id");
		}
	}

	@Override
    public List<Vehicle> searchVehicles(VehicleDTO vehicleDTO) {
        return vehicleRepository.search(vehicleDTO);
    }
	
	private boolean isVehicleAlreadyExist (String stateNumber) {
		if (vehicleRepository.findByStateNumber(stateNumber).isPresent()) {
			return true;
		}
		else return false;
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
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет транспортного средства с таким id");
		}
	}
	
	

}
