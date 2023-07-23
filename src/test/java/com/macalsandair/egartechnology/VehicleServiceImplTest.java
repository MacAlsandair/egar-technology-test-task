package com.macalsandair.egartechnology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.macalsandair.egartechnology.vehicle.Bus;
import com.macalsandair.egartechnology.vehicle.Car;
import com.macalsandair.egartechnology.vehicle.Truck;
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
    public void whenAddVehicleValidCar_thenReturnSameVehicle() {
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
        assertTrue(actualVehicle instanceof Car);
    }

    @Test
    public void whenAddVehicleValidTruck_thenReturnSameVehicle() {
      // Arrange
      VehicleDTO vehicleDTO = new VehicleDTO();
      vehicleDTO.setVehicleType("truck");
      vehicleDTO.setStateNumber("XYZ-456");
      Vehicle expectedVehicle = new Truck(vehicleDTO);

      when(vehicleRepository.findByStateNumber(any(String.class))).thenReturn(Optional.empty());
      when(vehicleRepository.save(any(Vehicle.class))).thenReturn(expectedVehicle);

      //Act
      Vehicle actualVehicle = vehicleService.addVehicle(vehicleDTO);

      // Assert
      assertEquals(expectedVehicle, actualVehicle);
      assertTrue(actualVehicle instanceof Truck);
    }

    @Test
    public void whenAddVehicleValidBus_thenReturnSameVehicle() {
       // Arrange
      VehicleDTO vehicleDTO = new VehicleDTO();
      vehicleDTO.setVehicleType("bus");
      vehicleDTO.setStateNumber("MNB-789");
      Vehicle expectedVehicle = new Bus(vehicleDTO);

      when(vehicleRepository.findByStateNumber(any(String.class))).thenReturn(Optional.empty());
      when(vehicleRepository.save(any(Vehicle.class))).thenReturn(expectedVehicle);

      //Act
      Vehicle actualVehicle = vehicleService.addVehicle(vehicleDTO);

      // Assert
      assertEquals(expectedVehicle, actualVehicle);
      assertTrue(actualVehicle instanceof Bus);
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

    @Test
    public void whenAddVehicleInvalidType_thenThrowsResponseStatusException(){
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("invalidType");
        vehicleDTO.setStateNumber("QWE-321");
        
        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> vehicleService.addVehicle(vehicleDTO));
    }


    
}



