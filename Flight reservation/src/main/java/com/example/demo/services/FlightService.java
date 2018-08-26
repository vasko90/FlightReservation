package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Flight;
import com.example.demo.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	
	public List<Flight>findFlights(String dc, String ac, String date) {
		return flightRepository.findAllFlights(dc, ac, date);
	}
	
	public Flight getFlight(int id) {
		return flightRepository.getOne(id);
	}
	
	public List<Flight> getArrivalCities() {
		return flightRepository.findArrivalCities();
	}
	
	public List<Flight> getDepartureCities() {
		return flightRepository.findDepartureCities();
	}
}
