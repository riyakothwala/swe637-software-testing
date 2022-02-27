package edu.gmu.swe645.assignment2;

import java.util.HashMap;
import java.util.Map;

public class RankingService {

	public Map<String, Integer> getRank(Customer customer) {
		Map<String, Integer> rank = new HashMap<>();
		rank.put("Riya", 1);
		rank.put("Daksha", 2);
		rank.put("Barid", 3);
		rank.put("Xavier", 4);
		return rank;
	}
}
