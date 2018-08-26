package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Flight;
import com.example.demo.entities.Passenger;
import com.example.demo.entities.Reservation;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.repositories.PassengerRepository;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.utility.EmailUtil;
import com.example.demo.utility.PDFCreator;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired 
	FlightRepository flightRepository;
	
	@Autowired
	PDFCreator pdf;
	
	@Autowired
	EmailUtil emailUtil;
	
	public Reservation createReservation(int id, String firstname, String lastname, String email){
		
		Flight flight = flightRepository.getOne(id);
		
		Passenger passenger = new Passenger();
		passenger.setFirstname(firstname);
		passenger.setLastname(lastname);
		passenger.setEmail(email);
		Passenger p = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setChecked_in(false);
		reservation.setFlight(flight);
		reservation.setPassenger(p);
		
		Reservation res = reservationRepository.save(reservation);
		
		String path = "D:/Video/ITA/PDFproba/reservation"+res.getId()+".pdf";
		pdf.generate(res, path);
		emailUtil.sendMail(p.getEmail(), path);
		
		return res;
	}
}
