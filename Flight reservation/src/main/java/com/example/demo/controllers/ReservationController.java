package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Flight;
import com.example.demo.entities.Passenger;
import com.example.demo.entities.Reservation;
import com.example.demo.services.FlightService;
import com.example.demo.services.ReservationService;

@Controller
public class ReservationController {

	
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	FlightService flightService;

	@RequestMapping(value="/createPassenger", method=RequestMethod.POST)
	public String newPassenger(@Valid @ModelAttribute("passenger") Passenger passenger, BindingResult result, @RequestParam("flightId")Integer id, Model model){
		
		if(result.hasErrors()) {
			Flight f = flightService.getFlight(id);
			model.addAttribute("flight", f);
			return "reservationPage";
		}
		
		Reservation reservation = reservationService.createReservation(id, passenger.getFirstname(), passenger.getLastname(), passenger.getEmail());
		model.addAttribute("reservation","Reservation with id:"+ reservation.getId() + " created successfully.");
		
		return "confirmReservation";
	}
	
	
	
}
