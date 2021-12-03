package com.springreciepes.courtReservations.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.springreciepes.courtReservations.models.Player;
import com.springreciepes.courtReservations.models.Reservation;
import com.springreciepes.courtReservations.models.SportType;

public class ReservationServiceImpl implements ReservationService {
	public static final SportType TENNIS = new SportType(1,"Tennis");
	public static final SportType SOCCER = new SportType(2,"Soccer");
	
	private final List<Reservation> reservations = new ArrayList<>();
	
	public ReservationServiceImpl() {
		reservations.add(new Reservation(
				"Tennis #1", 
				new Date(2008, 1,14),
				16,
				new Player("Roger","N/A"),
				TENNIS));
		reservations.add(new Reservation(
				"Tennis #2", 
				new Date(2008, 1,14),
				20,
				new Player("James","N/A"),
				TENNIS));
	}
	@Override
	public List<Reservation> query(String courtName) {
		
		return this.reservations.stream()
				.filter(reservation -> Objects.equals(reservation.getCourtName(), courtName))
				.collect(Collectors.toList());
	}

}
