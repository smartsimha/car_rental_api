package com.ty.carrentalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapi.dto.Customer;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "save customer",notes = "input is customer object and return same object with id")
	@ApiResponses(value = {@ApiResponse(code =201, message="successfully saved" ),@ApiResponse(code = 404 ,message = "input mismatch")})
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	
	@ApiOperation(value = "find customer by email",notes = "we can fetch the customer obj by passing email")
	@ApiResponses(value = {@ApiResponse(code =404, message="NoIdFoundException" )})
	@GetMapping(value = "/email/{email}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(@PathVariable String email) {
		return customerService.findCustomerByEmail(email);
	}
	
	@ApiOperation(value = "find customer by id",notes = "we can fetch the customer obj by passing id")
	@ApiResponses(value = {@ApiResponse(code =404, message="NoIdFoundException" )})
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@ApiOperation(value = "get all customers",notes = "we can fetch the customers present")
	@ApiResponses(value = {@ApiResponse(code =404, message="No customers present" )})
	@GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@ApiOperation(value = "update customer",notes = "input is customer object and return same object with id")
	@ApiResponses(value = {@ApiResponse(code =200, message="successfully updated" ),@ApiResponse(code = 404 ,message = "input mismatch")})
	@PutMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@ApiOperation(value = "delete customer",notes = "delete the customer by specified id")
	@ApiResponses(value = {@ApiResponse(code =404, message="No customers present" )})
	@DeleteMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<String>>deleteCustomerById(@PathVariable int id) {
		return customerService.deleteCustomerById(id);
	}
	
	@ApiOperation(value = "login customer", notes = "input is customer email and password return login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully login"),
			@ApiResponse(code = 404, message = "InvalidCredentialException") })
	@GetMapping(value = "/email/{email}/password/{password}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<ResponseStructure<Customer>> customerLogin(String email, String password) {
		
		return customerService.customerLogin(email, password);
	}
}
