package com.example.reservationCheckIn.client;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.reservationCheckIn.client.entities.Reservation;
import com.example.reservationCheckIn.client.entities.ReservationUpdate;

@Component
public class RestClientImplementation implements RestClient {

	@Override
	public Reservation getReservation(int id) {

		RestTemplate rt = new RestTemplate();
		Reservation reservation = null;
		reservation = rt.getForObject("http://localhost:9090/reservation/"+id, Reservation.class);
		
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdate update) {
		
	    RestTemplate rt = new RestTemplate();
	    return rt.postForObject("http://localhost:9090/reservationUpdate", update, Reservation.class);

	}

}
