package com.ty.carrentalapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapi.dto.Admin;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "save admin", notes = "input is admin object and return same object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@ApiOperation(value = "find admin by id", notes = "We can fetch the admin obj by passing id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "NoIdFoundException") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}

	@ApiOperation(value = "find admin by email", notes = "we can fetch the admin obj by passing email")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "InvalidEmailException") })
	@GetMapping(value = "/email/{email}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@PathVariable String email) {
		return adminService.getAdminByEmail(email);
	}

	@ApiOperation(value = "delete admin", notes = "input is admin id and return delete status")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "NoIdFoundException") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteAdminById(@PathVariable int id) {
		return adminService.deleteAdminById(id);

	}

	@ApiOperation(value = "login admin", notes = "input is admin email and password return login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully login"),
			@ApiResponse(code = 404, message = "InvalidCredentialException") })
	@GetMapping(value = "/email/{email}/password/{password}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String email, String password) {
		return adminService.adminLogin(email, password);
	}
}
