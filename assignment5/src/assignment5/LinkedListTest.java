package assignment5;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

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
	
	/* This test focuses on the following methods from LinkedList:
	 * LinkedList(), removeFirst(), contains(Object o), addAll(LinkedList<E> c)
	 * set(int index, E element), indexOf(), poll(), offerLast(), pollLast(),
	 * removeLastOccurrence()
	 */
	@Test
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
		
		//call offerLast() method to add 6 to the end of Linked List
		lLI.offerLast(6);
		
		//verify value at expected position
		assertEquals(6,lLI.get(3));
		
		//call and verify pollLast() method
		assertEquals(6,lLI.pollLast());
		
		//call and verify outcome of removeLastOccurrence() method
		assertEquals(true,lLI.removeLastOccurrence(5));
	}
	
	/* This test focuses on alternative branches for the following methods from LinkedList:
	 * remove(), contains(), indexof(), poll(), pollLast(), removeLastOccurrence()
	 */
	@Test
	void test2() {
		System.out.println("Starting Test 2");
		
		//create new LinkedList object to test method LinkedList()
		lLI = new LinkedList<Integer> ();
		
		//test and verify alternative branch of remove() method
		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			lLI.remove();
	    });
		
		lLI.add(1);
		
		//test and verify alternative branch of contains() method
		assertEquals(false,lLI.contains(2));
		
		//test and verify alternative branch of indexOf() method
		assertEquals(-1,lLI.indexOf(null));
		
		//add null to linked list
		lLI.add(null);
		
		//for full coverage call indexOf() method with null already in list
		assertEquals(1,lLI.indexOf(null));
		
		//reset list to an empty list
		lLI = new LinkedList<Integer> ();
		
		//test and verify alternative branch of poll() method
		assertEquals(null,lLI.poll());
		
		//test and verify alternative branch of pollLast() method
		assertEquals(null,lLI.pollLast());
		
		lLI.add(1);
		
		//test and verify alternative branch of removeLastOccurrence() method
		assertEquals(false,lLI.removeLastOccurrence(null));
		
		lLI.add(null);
		
		//test and verify alternative branch of removeLastOccurrence() method
		assertEquals(true,lLI.removeLastOccurrence(null));
		
		//lastly, for full coverage of removeLastOccurrence() method test method where we look
		//for element in list with elements where the element we are looking for dosen't
		//exsist in list
		assertEquals(false,lLI.removeLastOccurrence(2));
	}
	////End of Barid's tests
	
	////Start of Daksha's tests
	////End of Daksha's tests
	
	////Start of Xavier's tests
	////End of Xavier's tests
	
	////Start of Riya's tests
	////End of Riya's tests
	
}
