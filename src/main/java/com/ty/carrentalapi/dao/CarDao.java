package com.ty.carrentalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Car;
import com.ty.carrentalapi.repository.CarRepository;

@Repository
public class CarDao {

	@Autowired
	private CarRepository carRepository;

	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	public Car findCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			carRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public Car updateCar(Car car) {
		Optional<Car> optional = carRepository.findById(car.getId());
		if (optional != null) {
			return carRepository.save(car);

		} else {
			return null;
		}
	}

}
