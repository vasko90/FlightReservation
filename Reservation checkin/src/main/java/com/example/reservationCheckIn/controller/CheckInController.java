package com.example.reservationCheckIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.reservationCheckIn.client.RestClientImplementation;
import com.example.reservationCheckIn.client.entities.Reservation;
import com.example.reservationCheckIn.client.entities.ReservationUpdate;

@Controller
public class CheckInController {

	@Autowired
	RestClientImplementation rci;
	
	
	@RequestMapping(value="/startCheckin", method=RequestMethod.POST)
	public String startReservation(@RequestParam("reservationId") Integer id, Model model){

		Reservation reservation = rci.getReservation(id);
        model.addAttribute("reservation", reservation);
		
        return "finishPage";
	}
	
	@RequestMapping(value="/finish", method=RequestMethod.POST)
	public String finishReservation(@RequestParam("reservation_id") Integer id, @RequestParam("bags_number")Integer bagsNo){
		
		ReservationUpdate reservationUpdate = new ReservationUpdate();
		reservationUpdate.setId(id);
		reservationUpdate.setBags_no(bagsNo);
		reservationUpdate.setCheckedIn(true);
		
		rci.updateReservation(reservationUpdate);
		
		return "confirmation";
	}
}
