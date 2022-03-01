package edu.gmu.swe645.assignment2;

import java.util.Objects;

public class Rank implements Comparable<Rank> {

	int rank;

	public Rank(int rank) {
		super();
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}


	@Override
	public int compareTo(Rank o) {
		return this.rank - o.rank;
	}

}
// Integer.valueOf(this.getRank()).compareTo(Integer.valueOf(o.getRank()))
