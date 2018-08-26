package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Flight;
import com.example.demo.entities.Passenger;
import com.example.demo.services.FlightService;

@Controller
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@RequestMapping(value="/findFlights", method=RequestMethod.POST)
	public String findFlights(@RequestParam("departureCity")String dcity, @RequestParam("arrivalCity")String acity, @RequestParam("date")String date, Model model) {
		
		model.addAttribute("flights", flightService.findFlights(dcity, acity, date));
		return "mainPage";
	}
	
	@RequestMapping("/createReservation")
	public String createReservation(@RequestParam("id")Integer id, Model model) {
		
		Flight f = flightService.getFlight(id);
		model.addAttribute("flight", f);
		model.addAttribute("passenger", new Passenger());
		
		return "reservationPage";
	}
}
