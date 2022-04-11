package assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	
	LinkedList<Integer> lLI;
	LinkedList<String> lLS;
	
	@BeforeEach
	void setup() {
		System.out.println("Setting up test...");
		
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Tearing down test...");
	
		lLI = null;
		lLS = null;
	}
	
	
	////Start of Barid's tests
	@Test
	
	//This test focuses on the following methods from LinkedList:
	//
	void test1() {
		System.out.println("Starting Test 1");
		
		//create new LinkedList object to test method LinkedList()
		lLI = new LinkedList<Integer> ();
		
		//verify lLI no longer == null
		assertNotEquals(null,lLI);
		
		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		
		//verify removeFirst() method returns what is expected
		assertEquals("1",lLI.removeFirst().toString());
		
		//verify contains() method works as expected
		assertEquals(true,lLI.contains(2));
		
		
	}
	////End of Barid's tests
	
	////Start of Daksha's tests
	////End of Daksha's tests
	
	////Start of Xavier's tests
	////End of Xavier's tests
	
	////Start of Riya's tests
	////End of Riya's tests
	
}
