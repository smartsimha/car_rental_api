package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

}
