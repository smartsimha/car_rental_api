package com.ty.carrentalapi.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pickUpLoc;
	private String dropUpLoc;
	private LocalDate fromDate;
	private LocalDate toDate;
	private double duration;

	@OneToOne
	@JoinColumn
	private Customer customer;
	@OneToOne
	private Payment payment;
	@OneToOne
	private Car car;
	@OneToOne
	private Driver driver;
	@ManyToOne
	@JoinColumn
	private Admin admin;

}
