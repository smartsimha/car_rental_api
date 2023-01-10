package com.ty.carrentalapi.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter Email id")
	private String name;
	@Column(unique = true)
	//@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter a proper email id")
	@NotBlank(message = "Please enter Email id")
	private String email;
	private String password;
	@Column(unique = true)
	@NotNull
	private long phone;
	//@NotNull
	private LocalDate dob;
	@NotNull
	private String address;

	@OneToOne(mappedBy = "customer")
	private Booking booking;

}
