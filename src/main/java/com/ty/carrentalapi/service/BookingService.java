package com.ty.carrentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapi.dao.BookingDao;
import com.ty.carrentalapi.dao.CarDao;
import com.ty.carrentalapi.dao.CustomerDao;
import com.ty.carrentalapi.dao.DriverDao;
import com.ty.carrentalapi.dao.PaymentDao;
import com.ty.carrentalapi.dto.Booking;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.exception.NoIdFoundException;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private CarDao carDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private DriverDao driverDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking) {
		ResponseEntity<ResponseStructure<Booking>> respo;
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(bookingDao.saveBooking(booking));
		return new ResponseEntity<ResponseStructure<Booking>>(HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking() {
		ResponseEntity<ResponseStructure<List<Booking>>> respo;
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
		List<Booking> booking = bookingDao.getAllBooking();
		if (!booking.isEmpty()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(booking);
			respo = new ResponseEntity<ResponseStructure<List<Booking>>>(HttpStatus.OK);

		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Booking" + " " + booking + " ");
			responseStructure.setData(booking);
			respo = new ResponseEntity<ResponseStructure<List<Booking>>>(HttpStatus.NOT_FOUND);

		}
		return respo;

	}

	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int booking_id) {
		ResponseEntity<ResponseStructure<Booking>> respo;
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		Booking booking = bookingDao.findBookingById(booking_id);
		if (booking != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(booking);
			respo = new ResponseEntity<ResponseStructure<Booking>>(HttpStatus.OK);
			return respo;
		} else {
			throw new NoIdFoundException("Id not found :" + booking_id + " ");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteBookingById(int booking_id) {
		ResponseEntity<ResponseStructure<String>> respo;
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (bookingDao.deleteBooking(booking_id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData("booking has been deleted ");
			respo = new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
			return respo;
		} else {
			throw new NoIdFoundException("Id not found :" + booking_id + " ");

		}

	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking) {
		ResponseEntity<ResponseStructure<Booking>> respo;
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(bookingDao.saveBooking(booking));
		return new ResponseEntity<ResponseStructure<Booking>>(HttpStatus.OK);

	}
}
