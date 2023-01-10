package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findCustomerByEmail(String Email);
	

}
