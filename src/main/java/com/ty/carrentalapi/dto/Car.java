package com.ty.carrentalapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String regno;
	private String modelName;
	private String brand;
	private String fuelType;
	private int noOfSeats;
	private int mileage;
	private double basePrice;
	private boolean availability;

}
