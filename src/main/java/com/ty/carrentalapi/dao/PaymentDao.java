package com.ty.carrentalapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Payment;
import com.ty.carrentalapi.repository.PaymentRepository;

@Repository
public class PaymentDao {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment savePayment(Payment Payment) {
		return paymentRepository.save(Payment);
	}

	public Payment getPaymentById(int id) {
		Optional<Payment> optional = paymentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;

		}

	}

	public boolean deletePaymentById(int id) {
		Optional<Payment> optional = paymentRepository.findById(id);
		if (optional.isPresent()) {
			paymentRepository.delete(optional.get());
			return true;
		} else {
			return false;

		}

	}

	public Payment updatePayment(Payment payment) {
		Optional<Payment> optional = paymentRepository.findById(payment.getId());
		if (optional != null) {
			return paymentRepository.save(payment);

		} else {
			return null;
		}

	}
}
