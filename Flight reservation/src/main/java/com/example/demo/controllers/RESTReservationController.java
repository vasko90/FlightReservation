package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.ReservationUpdate;
import com.example.demo.exceptions.ReservationNotFoundException;
import com.example.demo.repositories.ReservationRepository;

@RestController
public class RESTReservationController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservation/{id}")
	public Reservation getReservation(@PathVariable("id")Integer id) throws ReservationNotFoundException{
		
		Reservation reservation = reservationRepository.getOne(id);
		if(reservation == null) {
			throw new ReservationNotFoundException("Reservation with id:"+id+" not found");
		}
			return reservation;
		
		
	}
	
	@RequestMapping(value="/reservationUpdate", method=RequestMethod.POST)
	public Reservation update(@RequestBody ReservationUpdate update) {
		
		Reservation reservation = reservationRepository.getOne(update.getId());
		reservation.setChecked_in(update.isCheckedIn());
		reservation.setNumber_of_bags(update.getBags_no());
		Reservation res = reservationRepository.save(reservation);
		
		return res;
	}
}
