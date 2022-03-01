package edu.gmu.swe645.assignment2;
import java.util.Random;

import java.util.HashMap;
import java.util.Map;

public class RankingService {

	public Rank getRank(Customer customer) {
		Random rand = new Random();

		int customer_rank = rand.nextInt(50);

		Rank rankObj = new Rank(customer_rank);

		return rankObj;
	}
}


