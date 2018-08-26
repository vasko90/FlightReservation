package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean checked_in;
	private int number_of_bags;
	@OneToOne
	@JoinColumn(name="passenger_id")
	private Passenger passenger;
	@OneToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isChecked_in() {
		return checked_in;
	}
	public void setChecked_in(boolean checked_in) {
		this.checked_in = checked_in;
	}
	public int getNumber_of_bags() {
		return number_of_bags;
	}
	public void setNumber_of_bags(int number_of_bags) {
		this.number_of_bags = number_of_bags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Reservation() {
		
	}
}
