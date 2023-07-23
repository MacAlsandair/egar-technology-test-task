package com.macalsandair.egartechnology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import com.macalsandair.egartechnology.vehicle.Car;
import com.macalsandair.egartechnology.vehicle.Vehicle;
import com.macalsandair.egartechnology.vehicle.VehicleDTO;
import com.macalsandair.egartechnology.vehicle.VehicleRepository;
import com.macalsandair.egartechnology.vehicle.VehicleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;
    
    
    @Test
    public void whenAddVehicleValidVehicle_thenReturnSameVehicle() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("car");
        vehicleDTO.setStateNumber("ABC-123");
        Vehicle expectedVehicle = new Car(vehicleDTO);
        
        when(vehicleRepository.findByStateNumber(any(String.class))).thenReturn(Optional.empty());
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(expectedVehicle);
        
        // Act
        Vehicle actualVehicle = vehicleService.addVehicle(vehicleDTO);
        
        // Assert
        assertEquals(expectedVehicle, actualVehicle);
    }

    @Test
    public void whenAddVehicleWithUsedStateNumber_thenThrowsResponseStatusException() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("car");
        vehicleDTO.setStateNumber("ABC-123");
        Vehicle existingVehicle = new Car(vehicleDTO);
        
        when(vehicleRepository.findByStateNumber(any(String.class))).thenReturn(Optional.of(existingVehicle));
        
        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> vehicleService.addVehicle(vehicleDTO));
    }

//    @Test
//    public void whenCreateVehicleWithTypeCar_thenReturnCar() {
//        // Arrange
//        VehicleDTO vehicleDTO = new VehicleDTO();
//        vehicleDTO.setVehicleType("car");
//
//        // Act
//        Vehicle vehicle = vehicleService.createVehicle(vehicleDTO);
//
//        // Assert
//        assertTrue(vehicle instanceof Car);
//    }
//
//    @Test
//    public void whenCreateVehicleWithTypeBus_thenReturnBus() {
//        // Arrange
//        VehicleDTO vehicleDTO = new VehicleDTO();
//        vehicleDTO.setVehicleType("bus");
//
//        // Act
//        Vehicle vehicle = vehicleService.createVehicle(vehicleDTO);
//
//        // Assert
//        assertTrue(vehicle instanceof Bus);
//    }
//
//    @Test
//    public void whenCreateVehicleWithTypeTruck_thenReturnTruck() {
//        // Arrange
//        VehicleDTO vehicleDTO = new VehicleDTO();
//        vehicleDTO.setVehicleType("truck");
//
//        // Act
//        Vehicle vehicle = vehicleService.createVehicle(vehicleDTO);
//
//        // Assert
//        assertTrue(vehicle instanceof Truck);
//    }
//
//    @Test
//    public void whenCreateVehicleWithInvalidType_thenThrowsResponseStatusException() {
//        // Arrange
//        VehicleDTO vehicleDTO = new VehicleDTO();
//        vehicleDTO.setVehicleType("invalidType");
//
//        // Act and Assert
//        assertThrows(ResponseStatusException.class, () -> vehicleService.createVehicle(vehicleDTO));
//    }

    
}



