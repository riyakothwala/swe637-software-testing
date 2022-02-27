package edu.gmu.swe645.assignment2;

import java.util.ArrayList;

public class ReservationService {
	
	private ArrayList<Customer> ReservationList;
	
	ReservationService(){
		this.ReservationList = new ArrayList<Customer>();
	}
	
	public void reserve(String name) {
		Customer newCustomer = new Customer(name);
		this.ReservationList.add(newCustomer);
	}
	
	public Customer getCustomer(int index) {
		return this.ReservationList.get(index);
	}
}
