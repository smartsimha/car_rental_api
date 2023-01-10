package com.ty.carrentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapi.dao.DriverDao;
import com.ty.carrentalapi.dto.Driver;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.exception.NoIdFoundException;

@Service
public class DriverService {
	@Autowired
	private DriverDao dao;

	public ResponseEntity<ResponseStructure<Driver>> saveDriver(Driver driver) {
		ResponseStructure<Driver> structure = new ResponseStructure<Driver>();

		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("CREATED");
		structure.setData(dao.saveDriver(driver));

		return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver() {

		ResponseStructure<List<Driver>> structure = new ResponseStructure<List<Driver>>();

		List<Driver> list = dao.getAllDrivers();
		if (list != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("FETCHED");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Driver>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("There is no customers");
			return new ResponseEntity<ResponseStructure<List<Driver>>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Driver>> getDriverById(int id) {
		ResponseStructure<Driver> structure = new ResponseStructure<Driver>();

		Driver driver = dao.getDriverById(id);
		if (driver != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("DATA-FOUND");
			structure.setData(driver);

			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("DATA NOT FOUND");
			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Driver>> findDriverByDl(String dl) {
		ResponseStructure<Driver> structure = new ResponseStructure<Driver>();

		Driver driver = dao.findDriverByDl(dl);
		if (driver != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("DETAILS - FOUND");
			structure.setData(driver);

			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("DETAILS NOT FOUND");
			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Driver>> deleteDriverById(int id) {
		ResponseStructure<Driver> structure = new ResponseStructure<Driver>();
		if (dao.deleteDriverById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("DELETED");

			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Id " + id + "Not Found ");
		}

	}

	public ResponseEntity<ResponseStructure<Driver>> updateDriver(Driver driver) {
		ResponseStructure<Driver> structure = new ResponseStructure<Driver>();

		if (dao.updateDriver(driver)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("UPDATED");

			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("NOT FOUND");
			return new ResponseEntity<ResponseStructure<Driver>>(structure, HttpStatus.NOT_FOUND);
		}
	}

}
