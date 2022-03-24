package edu.gmu.swe645.assignment3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalTest {
	// Define test inputs and expected output
	public int m1, d1, m2, d2, y, expectedNumday;

	// Create a constructor to set up the parameterized data
	public CalTest(int m1, int d1, int m2, int d2, int y) {

		this.m1 = m1;
		this.d1 = d1;
		this.m2 = m2;
		this.d2 = d2;
		this.y = y;

	}

	@Parameters
	public static List<Integer[]> parameters() throws IOException {
		List<Integer[]> records = new ArrayList<>();
		String record;
		String testFilePath = "./output(Pairwise).csv"; //Pairwise test data file
		// String testFilePath = "./output.csv";        // All combination data file
		BufferedReader file = new BufferedReader(new FileReader(testFilePath));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			Integer[] array = new Integer[fields.length];
			for (int i = 0; i < fields.length; i++) {
				array[i] = Integer.valueOf(fields[i]);
			}
			records.add(array);
		}
		file.close();
		return records;
	}

	@Test
	public void testManyValues() {
		LocalDate dateBefore = LocalDate.of(y, m1, d1);
		LocalDate dateAfter = LocalDate.of(y, m2, d2);
		long expectedNumday = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		assertEquals(expectedNumday, Cal.cal(m1, d1, m2, d2, y));
	}
}
