package com.macalsandair.egartechnology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
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

    @Test
    public void whenUpdateVehicleValidCar_thenReturnUpdatedVehicle() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("car");
        vehicleDTO.setStateNumber("ABC-123");
        Vehicle updatedVehicle = new Car(vehicleDTO);
        updatedVehicle.setId(1L);
        
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(updatedVehicle));
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(updatedVehicle);
        
        // Act
        Vehicle actualVehicle = vehicleService.updateVehicle(vehicleDTO, 1L);
        
        // Assert
        assertEquals(updatedVehicle, actualVehicle);
        assertTrue(actualVehicle instanceof Car);
    }

    @Test
    public void whenUpdateVehicleValidTruck_thenReturnUpdatedVehicle() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("truck");
        vehicleDTO.setStateNumber("XYZ-456");
        Vehicle updatedVehicle = new Truck(vehicleDTO);
        updatedVehicle.setId(2L);

        when(vehicleRepository.findById(2L)).thenReturn(Optional.of(updatedVehicle));
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(updatedVehicle);

        //Act
        Vehicle actualVehicle = vehicleService.updateVehicle(vehicleDTO, 2L);

        // Assert
        assertEquals(updatedVehicle, actualVehicle);
        assertTrue(actualVehicle instanceof Truck);
    }

    @Test
    public void whenUpdateVehicleValidBus_thenReturnUpdatedVehicle() {
       // Arrange
       VehicleDTO vehicleDTO = new VehicleDTO();
       vehicleDTO.setVehicleType("bus");
       vehicleDTO.setStateNumber("MNB-789");
       Vehicle updatedVehicle = new Bus(vehicleDTO);
       updatedVehicle.setId(3L);

       when(vehicleRepository.findById(3L)).thenReturn(Optional.of(updatedVehicle));
       when(vehicleRepository.save(any(Vehicle.class))).thenReturn(updatedVehicle);

       //Act
       Vehicle actualVehicle = vehicleService.updateVehicle(vehicleDTO, 3L);

        // Assert
        assertEquals(updatedVehicle, actualVehicle);
        assertTrue(actualVehicle instanceof Bus);
    }

    @Test
    public void whenUpdateVehicleInvalidType_thenThrowsResponseStatusException(){
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("invalidType");
        vehicleDTO.setStateNumber("QWE-321");
       
        // Act and Assert
        assertThrows(ResponseStatusException.class, 
                     () -> vehicleService.updateVehicle(vehicleDTO, 4L));
    }

    @Test
    public void whenUpdateVehicleInvalidID_thenThrowsResponseStatusException(){
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("car");
        vehicleDTO.setStateNumber("RST-987");
        long invalidId = 10L;

        when(vehicleRepository.findById(invalidId)).thenReturn(Optional.empty());
       
       // Act and Assert
       assertThrows(ResponseStatusException.class, 
                    () -> vehicleService.updateVehicle(vehicleDTO, invalidId));
    }

    @Test
    public void whenGetAllVehicles_thenReturnVehicleList() {
        // Arrange
        VehicleDTO vehicleDTO1 = new VehicleDTO();
        vehicleDTO1.setVehicleType("car");
        vehicleDTO1.setStateNumber("ABC-123");
        
        VehicleDTO vehicleDTO2 = new VehicleDTO();
        vehicleDTO2.setVehicleType("truck");
        vehicleDTO2.setStateNumber("XYZ-456");
        
        List<Vehicle> expectedVehicles = Arrays.asList(new Car(vehicleDTO1), new Truck(vehicleDTO2));
        
        when(vehicleRepository.findAll()).thenReturn(expectedVehicles);
        
        // Act
        List<Vehicle> actualVehicles = vehicleService.getAllVehicles();
        
        // Assert
        assertEquals(expectedVehicles, actualVehicles);
    }

    @Test
    public void whenGetVehicleByIdValidId_thenReturnVehicle() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType("bus");
        vehicleDTO.setStateNumber("MNB-789");
        Vehicle expectedVehicle = new Bus(vehicleDTO);
        
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(expectedVehicle));
        
        // Act
        Vehicle actualVehicle = vehicleService.getVehicleById(1L);
        
        // Assert
        assertEquals(expectedVehicle, actualVehicle);
    }

    @Test
    public void whenGetVehicleByIdInvalidId_thenThrowsResponseStatusException() {
        // Arrange
        Long invalidId = 10L;
        when(vehicleRepository.findById(invalidId)).thenReturn(Optional.empty());
        
        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> vehicleService.getVehicleById(invalidId));
    }

    
}



