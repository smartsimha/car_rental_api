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

import com.ty.carrentalapi.dto.Car;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.service.CarService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@ApiOperation(value = "save car",notes = "input is car object and return same object with id")
	@ApiResponses(value = {@ApiResponse(code =201, message="successfully saved" ),@ApiResponse(code = 404 ,message = "input mismatch")})
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}
	
	
	@ApiOperation(value = "find car by id",notes = "we can fetch the car obj by passing id")
	@ApiResponses(value = {@ApiResponse(code =404, message="NoIdFoundException" )})
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Car>> getCarById(@PathVariable int id) {
		return carService.getCarById(id);
	}
	
	@ApiOperation(value = "get all cars",notes = "we can fetch the customers present")
	@ApiResponses(value = {@ApiResponse(code =404, message="No car present" )})
	@GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<List<Car>>> getAllCar() {
		return carService.getAllCar();
	}

	@ApiOperation(value = "delete car",notes = "input is car_id  and return status message")
	@ApiResponses(value = {@ApiResponse(code =200, message="successfully deleted" ),@ApiResponse(code = 404 ,message = "input mismatch")})
	@DeleteMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<String>> deleteCarById(@PathVariable int id) {
		return carService.deleteCarById(id);
	}
	
	@ApiOperation(value = "update car",notes = "input is car object and return same object with id")
	@ApiResponses(value = {@ApiResponse(code =200, message="successfully updated" ),@ApiResponse(code = 404 ,message = "input mismatch")})
	@PutMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Car>> updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}
	
	

	

}
