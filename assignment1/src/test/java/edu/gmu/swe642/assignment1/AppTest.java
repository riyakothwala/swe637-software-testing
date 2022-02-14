package edu.gmu.swe642.assignment1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AppTest {
	// Define test inputs and expected output
	public int m1, d1, m2, d2, y, expectedNumday;

	// Create a constructor to set up the parameterized data
	public AppTest(int m1, int d1, int m2, int d2, int y, int expectedNumday) {

		this.m1 = m1;
		this.d1 = d1;
		this.m2 = m2;
		this.d2 = d2;
		this.y = y;
		this.expectedNumday = expectedNumday;
	}

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { 
			/* we write the test cases that covers(total 8 cases):
 
			 * 	A) All the months(Jan to december), 
			 * 	B) Check the if part(month1 equal to month2) and else part(month1 not equal to month2),
			 * 	C) Check for leap year(numday 29) and not leap year(numday 28)  */
			
			
			/* If block test cases*/
				
				{ 1, 20, 1, 24, 2021, 4 },		// 0) same month and day1 is not divisible by day2, also covers the 'January' Month
				{ 2, 5, 2, 25, 2021, 20 },  	// 1) same month and day1 divisible by day2, also covers the 'Feb' month
				{ 3, 20, 3, 20, 2021, 0 },  	// 2) same month and same day (In short two dates are equal), covers 'March' Month
				
			/* else block test cases */
				{ 5, 27, 6, 10, 2021, 14 }, 	// 3) Not same month and no gap between two month(consecutive months), cover 'May' and 'June'
				{ 7, 27, 9, 10, 2021, 45 }, 	// 4) Not same month and gap between two month(Not consecutive months), cover 'July' and 'September' 
				{ 11, 27, 12, 10, 2021, 13 },   // 5) cover 'November' and 'December'months
				{ 2, 8, 4, 20, 2020, 72 },      // 6) Leap year and cover 'April' month
				{ 8, 28, 10, 2, 2021, 35 },     // 7) Not leap year and cover 'August' and 'october' months 
		});			
	}

	@Test
	public void testManyValues() {
		assertEquals(expectedNumday, Cal.cal(m1, d1, m2, d2, y));
	}
}
