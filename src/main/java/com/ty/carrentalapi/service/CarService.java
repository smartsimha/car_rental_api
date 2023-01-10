package com.ty.carrentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapi.dao.CarDao;
import com.ty.carrentalapi.dto.Car;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.exception.NoIdFoundException;

@Service
public class CarService {
	@Autowired
	private CarDao carDao;

	public ResponseEntity<ResponseStructure<Car>> saveCar(Car car) {

		ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(carDao.saveCar(car));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Car>> getCarById(int id) {

		Car car = carDao.findCarById(id);
		ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
		if (car != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(car);
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException("Id " + id + "Not Found ");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteCarById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (carDao.deleteCarById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setMessage("Deleted member");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Car with " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Car>>> getAllCar() {
		ResponseStructure<List<Car>> responseStructure = new ResponseStructure<List<Car>>();

		List<Car> cars = carDao.getAllCar();

		if (cars != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(cars);
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Data Not Found");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Car>> updateCar(Car car) {

		ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(carDao.saveCar(car));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

}
