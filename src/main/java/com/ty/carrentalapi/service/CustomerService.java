package com.ty.carrentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapi.dao.CustomerDao;
import com.ty.carrentalapi.dto.Customer;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.exception.InvalidCredentialException;
import com.ty.carrentalapi.exception.InvalidEmailException;
import com.ty.carrentalapi.exception.NoIdFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(String email) {
		Customer customer = customerDao.findCustomerByEmail(email);
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		if (customer != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Customer with " + email + " not found");
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		if (customer != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Customer with " + id + " not found");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteCustomerById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (customerDao.deleteCustomerById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setMessage("Deleted member");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Customer with " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<List<Customer>>();

		List<Customer> customer = customerDao.getAllCustomer();

		if (customer != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Data Not Found");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> customerLogin(String email, String password) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");

		Customer customer = customerDao.findCustomerByEmail(email);

		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Success");
				responseStructure.setData(customer);
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidCredentialException();
			}
		} else {
			throw new InvalidEmailException();
		}
	}
}
