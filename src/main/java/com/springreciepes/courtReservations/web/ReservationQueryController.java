package com.springreciepes.courtReservations.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springreciepes.courtReservations.models.Reservation;
import com.springreciepes.courtReservations.service.ReservationService;

public class ReservationQueryController {
	private final ReservationService reservationService;
	
	public ReservationQueryController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	@GetMapping
	public void setupForm() {}
	
	@PostMapping
	public String submitForm(@RequestParam("courtName") String courtName, Model model) {
		List<Reservation> reservations = java.util.Collections.emptyList();
		if(courtName != null) {
			reservations = reservationService.query(courtName);
		}
		model.addAttribute("reservations",reservations);
		return "reservationQuery";
	}
}
