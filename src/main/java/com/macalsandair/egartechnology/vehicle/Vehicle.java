package com.macalsandair.egartechnology.vehicle;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Category category;
    private String stateNumber;
    private TypeOfVehicle typeOfVehicle;
    private int yearOfManufacture;
    private boolean hasTrailer;
	
}
