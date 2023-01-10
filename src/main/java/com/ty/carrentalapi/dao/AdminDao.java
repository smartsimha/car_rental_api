package com.ty.carrentalapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Admin;
import com.ty.carrentalapi.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		} else {
			return null;
		}

	}

	public boolean deleteAdminById(int admin_id) {
		Optional<Admin> admin = adminRepository.findById(admin_id);
		if (admin.isPresent()) {
			adminRepository.delete(admin.get());
			return true;

		} else {
			return false;
		}
	}

	public Admin findAdminByEmail(String email) {

		Admin admin = adminRepository.findAdminByEmail(email);
		if (admin != null) {
			return admin;

		} else {
			return null;
		}

	}

}
