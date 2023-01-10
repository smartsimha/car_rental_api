package com.ty.carrentalapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@NotNull
	private int age;
	@NotNull
	private long phone;
	@NotBlank(message = "Please enter License Details")
	private String dl;
	private String address;
	private double bata;

}
