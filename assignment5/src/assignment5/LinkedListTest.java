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
	//LinkedList(), removeFirst(), contains(Object o), addAll(LinkedList<E> c)
	//set(int index, E element), indexOf(), poll()
	void test1() {
		System.out.println("Starting Test 1");
		
		//create new LinkedList object to test method LinkedList()
		lLI = new LinkedList<Integer> ();
		
		//verify lLI no longer == null
		assertNotEquals(null,lLI);
		
		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);
		
		//verify removeFirst() method returns what is expected
		assertEquals("1",lLI.removeFirst().toString());
		
		//verify contains() method works as expected
		assertEquals(true,lLI.contains(2));
		
		LinkedList<Integer> lLI2 = new LinkedList<Integer>();
		
		//test addAll() method
		lLI2.addAll(lLI);
		
		//verify lLI2 contains what is expected
		assertEquals("2",lLI2.get(0).toString());
		assertEquals("3",lLI2.get(1).toString());
		assertEquals("4",lLI2.get(2).toString());
		assertEquals("5",lLI2.get(3).toString());
		
		//test set(int index, E element) method
		lLI.set(0, 5);
		
		//verify that set() method worked as expected
		assertEquals("5",lLI.get(0).toString());
		
		//verify/test of indexOf() method
		assertEquals(0, lLI.indexOf(5));
		
		//verify/test of poll() method
		assertEquals("5", lLI.poll().toString());
		
	}
	////End of Barid's tests
	
	////Start of Daksha's tests
	////End of Daksha's tests
	
	////Start of Xavier's tests
	////End of Xavier's tests
	
	////Start of Riya's tests
	////End of Riya's tests
	
}
