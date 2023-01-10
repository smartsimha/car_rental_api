package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
