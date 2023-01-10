package com.ty.carrentalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Driver;
import com.ty.carrentalapi.repository.DriverRespository;

@Repository
public class DriverDao {

	@Autowired
	private DriverRespository respository;

	public Driver saveDriver(Driver driver) {
		return respository.save(driver);
	}

	public Driver getDriverById(int id) {
		Optional<Driver> opt = respository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	public List<Driver> getAllDrivers() {
		return respository.findAll();
	}

	public Driver findDriverByDl(String dl) {
		return respository.findDriverByDl(dl);
	}

	public boolean deleteDriverById(int id) {
		Optional<Driver> opt = respository.findById(id);
		if (opt.isEmpty()) {
			return false;
		} else {
			respository.delete(opt.get());
			return true;
		}
	}

	public boolean updateDriver(Driver driver) {
		Optional<Driver> opt = respository.findById(driver.getId());
		if (opt.isEmpty()) {
			return false;
		} else {
			respository.save(opt.get());
			return true;
		}
	}

}
