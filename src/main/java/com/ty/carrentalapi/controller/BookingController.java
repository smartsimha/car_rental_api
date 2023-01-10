package com.ty.carrentalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapi.dto.Booking;
import com.ty.carrentalapi.dto.ResponseStructure;
import com.ty.carrentalapi.service.BookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@ApiOperation(value = "save booking", notes = "input is booking object and return same object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}

	@ApiOperation(value = "find booking by id", notes = "we can fetch the booking obj by passing id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "NoIdFoundException") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@PathVariable int booking_id) {
		return bookingService.getBookingById(booking_id);
	}

	@ApiOperation(value = "update booking", notes = "input is booking object and return same object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}

	@ApiOperation(value = "get all bookings", notes = "we can fetch the bookings present")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "No bookings present") })
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@ApiOperation(value = "delete booking", notes = "delete the booking by specified id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "No booking present with given id") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteBookingById(@PathVariable int booking_id) {
		return bookingService.deleteBookingById(booking_id);
	}

}
