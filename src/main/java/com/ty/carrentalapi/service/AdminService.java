package com.ty.carrentalapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapi.dao.AdminDao;
import com.ty.carrentalapi.dto.Admin;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.exception.InvalidCredentialException;
import com.ty.carrentalapi.exception.InvalidEmailException;
import com.ty.carrentalapi.exception.NoIdFoundException;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(adminDao.saveAdmin(admin));

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int adminId) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.getAdminById(adminId);
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(admin);
		} else {
			throw new NoIdFoundException("Id " + adminId + "Not Found ");

		}
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String email) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.findAdminByEmail(email);
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(admin);
		} else {
			throw new InvalidEmailException("Email  " + email + "Not Found ");

		}
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(adminDao.saveAdmin(admin));

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAdminById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (adminDao.deleteAdminById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setMessage("Deleted member");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Customer with " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String email, String password)
	{
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.findAdminByEmail(email);
if(admin!=null) {
	if(admin.getPassword().equals(password))
	{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(admin);
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}
	else
	{
		throw new InvalidCredentialException();
	}
}
else
{
	throw new InvalidEmailException();
}
	}

}
