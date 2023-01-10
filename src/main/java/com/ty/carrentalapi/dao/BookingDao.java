package com.ty.carrentalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapi.dto.Booking;
import com.ty.carrentalapi.repository.BookingRepository;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private CarDao carDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private PaymentDao paymentDao;

	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	public Booking findBookingById(int booking_id)
	{
		Optional<Booking> booking=bookingRepository.findById(booking_id);
		if(booking.isPresent())
		{
			return booking.get();
		} else {
			return null;
		}
		
	}

	public List<Booking> getAllBooking() {
		List<Booking> bookings= bookingRepository.findAll();
		if(bookings.isEmpty()) {
			return null;
		} else {
			return bookings;
		}
	}


	public boolean deleteBooking(int booking_id){
		Optional<Booking> booking=bookingRepository.findById(booking_id);
		if(booking.isPresent()) {
			bookingRepository.delete(booking.get());
			return true;
			
		}else {
			return false;
		}
	}
	

	public Booking updateBooking(Booking booking) {
		Optional<Booking> optional = bookingRepository.findById(booking.getId());
		if (optional.isPresent()) {
			return bookingRepository.save(booking);
			
		} else {
			return null;
		}
	}

	

}
