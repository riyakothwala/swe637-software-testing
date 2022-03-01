package edu.gmu.swe645.assignment2;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

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
		
		final Customer barid = new Customer("Riya");
		final Rank baridRank = new Rank(1);

		final Customer xavier = new Customer("Daksha");
		final Rank xavierRank = new Rank(2);
		
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

		Map<Rank, Customer> reservationListExpected = new TreeMap<Rank, Customer>();
		reservationListExpected.put(riyaRank, riya);
		reservationListExpected.put(dakshRank, daksha);
		reservationListExpected.put(baridRank, barid);
		reservationListExpected.put(xavierRank, xavier);
		
		ReservationService reservationService = new ReservationService();
		reservationService.reserve(riya);
		reservationService.reserve(daksha);
		reservationService.reserve(barid);
		reservationService.reserve(xavier);

		assertEquals(reservationListExpected, reservationService.getReservationList());

	}

}
