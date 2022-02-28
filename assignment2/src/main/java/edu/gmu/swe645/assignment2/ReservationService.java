package edu.gmu.swe645.assignment2;


import java.util.ArrayList;
import java.util.Collections;


public class ReservationService {
	
	RankingService rankingService;
	ArrayList<Customer> reservationList;
	
	ReservationService(){
		this.reservationList = new ArrayList<Customer>();
	}
	
	public void reserve(String name, int rank) {
		Customer newCust = new Customer(name, rank);
		this.reservationList.add(newCust);
	}
	
	public Customer getCustomer(int index) {
		return this.reservationList.get(index);
	}
	
	public void sortAssendingRank() {
		Collections.sort(this.reservationList);
	}
}
