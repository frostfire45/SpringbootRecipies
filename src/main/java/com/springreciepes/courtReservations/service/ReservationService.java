package com.springreciepes.courtReservations.service;

import java.util.List;

import com.springreciepes.courtReservations.models.Reservation;

public interface ReservationService {
	public List<Reservation> query(String courtName);
}
