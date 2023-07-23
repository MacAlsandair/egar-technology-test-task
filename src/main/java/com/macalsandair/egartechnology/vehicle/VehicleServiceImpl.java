package com.macalsandair.egartechnology.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(VehicleDTO vehicleDTO) {
		if (!isVehicleAlreadyExist(vehicleDTO.getStateNumber())) {
			switch (vehicleDTO.getVehicleType()) {
			case "car":
				Car newCar = new Car(vehicleDTO);
				return vehicleRepository.save(newCar);
			case "truck":
				Truck newTruck = new Truck(vehicleDTO);
				return vehicleRepository.save(newTruck);
			case "bus":
				Bus newBus = new Bus(vehicleDTO);
				return vehicleRepository.save(newBus);
			default:
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрос некорректен. Такого типа ТС не может быть в системе");
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Этот государственный номер уже есть в системе");
		}
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO vehicleDTO, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleDTO> searchVehicles(String brand, String model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isVehicleAlreadyExist (String stateNumber) {
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
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет транспортного средства с таким id");
		}
	}
	
	

}
