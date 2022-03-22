package edu.gmu.swe645.assignment3;

public class Cal {
	public static int cal(int month1, int day1, int month2, int day2, int year) {

		// ***********************************************************
		// Calculate the number of Days between the two given days in
		// the same year in accordance with the Gregorian calendar.
		// preconditions:
		// 1. day1 and day2 must be in same year
		// 2. 1 <= month1, month2 <= 12
		// 3. 1 <= day1 <= maxDaysInMonth1
		// where maxDaysInMonth1 is defined as the largest valid
		// day in the specified month1 and year, including any
		// leap year, as per the Gregorian calendar
		// 4. 1 <= day2 <= maxDaysInMonth2
		// where maxDaysInMonth2 is defined as the largest valid
		// day in the specified month2 and year, including any
		// leap year, as per the Gregorian calendar
		// 5. month1 <= month2
		// 6. month1 == month2 implies day1 <= day2
		// 7. 1 <= year <= 10000
		// ***********************************************************

		int numDays;

		if (month2 == month1) // in the same month
			numDays = day2 - day1;
		else {
			// Skip month 0.
			int daysIn[] = { 0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			// Are we in a leap year?
			int m4 = year % 4;
			int m100 = year % 100;
			int m400 = year % 400;

			if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
				daysIn[2] = 28;
			else
				daysIn[2] = 29;

			// start with days in the two months
			numDays = day2 + (daysIn[month1] - day1);

			// add the days in the intervening months
			for (int i = month1 + 1; i < month2; i++)
				numDays = daysIn[i] + numDays;
		}
		return (numDays);
	}
}