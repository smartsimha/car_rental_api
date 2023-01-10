package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
