package edu.gmu.swe645.assignment2;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class ReservationServiceTest {

	@Mocked
	RankingService rankingServiceMock;

	@Test
	public void testReservationService() {

		final Customer riya = new Customer("Riya");
		final Rank riyaRank = new Rank(1);

		final Customer daksha = new Customer("Daksha");
		Rank dakshRank = new Rank(2);
		
		final Customer barid = new Customer("Barid");
		final Rank baridRank = new Rank(3);

		final Customer xavier = new Customer("Xavier");
		final Rank xavierRank = new Rank(4);
		
		new Expectations() {
			{
				rankingServiceMock.getRank(riya);
				returns(riyaRank, riyaRank, riyaRank);
			}
			{
				rankingServiceMock.getRank(daksha);
				returns(dakshRank, dakshRank, dakshRank);
			}
			{
				rankingServiceMock.getRank(barid);
				returns(baridRank,baridRank,baridRank);
			}
			{
				rankingServiceMock.getRank(xavier);
				returns(xavierRank,xavierRank,xavierRank);
			}
		};

		Map<Rank, Customer> reservationListExpected = new HashMap<Rank, Customer>();
		reservationListExpected.put(riyaRank, riya);
		reservationListExpected.put(dakshRank, daksha);
		reservationListExpected.put(baridRank, barid);
		reservationListExpected.put(xavierRank, xavier);
		
		ReservationService reservationService = new ReservationService();
		// order should not matter.
		reservationService.reserve(riya);
		reservationService.reserve(daksha);
		reservationService.reserve(barid);
		reservationService.reserve(xavier);

		assertEquals(reservationListExpected, reservationService.getReservationList());

	}

}
