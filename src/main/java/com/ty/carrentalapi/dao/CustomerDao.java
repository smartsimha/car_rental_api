package com.ty.carrentalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Customer;
import com.ty.carrentalapi.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repository;

	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer getCustomerById(int id) {
		Optional<Customer> opt = repository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	public List<Customer> getAllCustomer() {
		return repository.findAll();
	}

	public Customer findCustomerByEmail(String email) {
		return repository.findCustomerByEmail(email);
	}

	public boolean deleteCustomerById(int id) {
		Optional<Customer> opt = repository.findById(id);
		if (opt.isEmpty()) {
			return false;
		} else {
			repository.delete(opt.get());
			return true;
		}
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer> opt = repository.findById(customer.getId());
		if (opt.isEmpty()) {
			return repository.save(customer);
		} else {
			repository.save(opt.get());
			return null;
		}

	}

}

