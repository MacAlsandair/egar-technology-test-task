package com.macalsandair.egartechnology.vehicle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository vehicleRepository;

	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
		if (!isVehicleAlreadyExist(vehicleDTO.getStateNumber())) {
			switch (vehicleDTO.getVehicleType()) {
			case "car":
				Car newCar = new Car(vehicleDTO);
				vehicleRepository.save(newCar);
				break;
				
			default:
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрос некорректен. Такого типа ТС не может быть в системе");
			}
			return null;
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
	
	

}
