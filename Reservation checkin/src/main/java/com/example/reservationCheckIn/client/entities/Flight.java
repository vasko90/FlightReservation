package com.example.reservationCheckIn.client.entities;

public class Flight {

	private int id;
	private int flight_number;
	private String operating_airlines;
	private String departure_city;
	private String arrival_city;
	private String departure_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getOperating_airlines() {
		return operating_airlines;
	}
	public void setOperating_airlines(String operating_airlines) {
		this.operating_airlines = operating_airlines;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	
	public Flight() {
		
	}
	
}
