package edu.gmu.swe645.assignment2;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReservationService {

	RankingService rankingService;
	Map<Rank, Customer> reservationList;

	ReservationService() {
		this.reservationList = new TreeMap<Rank, Customer>();
		this.rankingService = new RankingService();
	}

	public void reserve(Customer c) {
		Rank r = rankingService.getRank(c);
		this.reservationList.put(r, c);
	}

	public Map<Rank, Customer> getReservationList() {
		return Collections.unmodifiableMap(this.reservationList);
	}

	@Override
	public String toString() {
		return "ReservationService [reservationList=" + reservationList + "]";
	}

}
