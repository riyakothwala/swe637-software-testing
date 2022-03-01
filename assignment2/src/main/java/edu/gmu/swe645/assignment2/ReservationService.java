package edu.gmu.swe645.assignment2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class ReservationService {
	
	RankingService rankingService;
	TreeMap<Rank, Customer> reservationList;
	
	ReservationService(){
		this.reservationList = new TreeMap<Rank, Customer>();
		this.rankingService = new RankingService();
	}
	
	public void reserve(Customer c) {
		Rank r = rankingService.getRank(c);
		this.reservationList.put(r, c);
	}
}
