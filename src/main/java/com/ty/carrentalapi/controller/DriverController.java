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

import com.ty.carrentalapi.dto.Driver;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.service.DriverService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/drivers")
public class DriverController {
	@Autowired
	private DriverService service;

	@ApiOperation(value = "save Driver", notes = "input is Driver object and return same object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(@RequestBody Driver driver) {
		return service.saveDriver(driver);
	}
	
	@ApiOperation(value = "find driver by id", notes = "we can fetch the driver obj by passing id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "NoIdFoundException") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Driver>> getDriverById(@PathVariable int id) {
		return service.getDriverById(id);
	}

	@ApiOperation(value = "get all drivers", notes = "we can fetch the drivers present")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "There are no drivers") })
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver() {
		return service.getAllDriver();
	}

	@ApiOperation(value = "find driver by dl", notes = "we can fetch the driver obj by passing his dl")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "NoDlFoundException") })
	@GetMapping(value = "/dl/{dl}", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Driver>> findDriverByDl(@PathVariable String dl) {
		return service.findDriverByDl(dl);
	}

	@ApiOperation(value = "delete driver by id", notes = "we can delete the driver obj by passing id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "NoIdFoundException") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Driver>> deleteDriverById(@PathVariable int id) {
		return service.deleteDriverById(id);
	}

	@ApiOperation(value = "update Driver", notes = "input is Driver object and return same object with id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully updated"),@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@RequestBody Driver driver) {
		return service.updateDriver(driver);
	}
}
