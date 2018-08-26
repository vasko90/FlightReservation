package com.example.reservationCheckIn.client;

import com.example.reservationCheckIn.client.entities.Reservation;
import com.example.reservationCheckIn.client.entities.ReservationUpdate;

public interface RestClient {

	public Reservation getReservation(int id);
	public Reservation updateReservation(ReservationUpdate update);
}
