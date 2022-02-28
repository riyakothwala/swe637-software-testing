package edu.gmu.swe645.assignment2;

public class Customer implements Comparable<Object>{

	private String name;
	private Rank rank;
	
	public Customer(String name, Integer rank) {
		super();
		this.name = name;
		this.rank = new Rank(rank);
	}

	public String getName() {
		return name;
	}
	
	public Integer getRank() {
		return this.rank.getRank();
	}

	@Override
	public int compareTo(Object o) {
		Customer c = (Customer) o;
		return this.getRank() - c.getRank();
	}
}
