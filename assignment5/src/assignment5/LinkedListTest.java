package assignment5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

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

	// ==============================================================================================================================

	/*
	 * This test focuses on the following methods from LinkedList: LinkedList(),
	 * removeFirst(), contains(Object o), addAll(LinkedList<E> c) set(int index, E
	 * element), indexOf(), poll(), offerLast(), pollLast(), removeLastOccurrence()
	 */
	@Test
	void test1() {
		System.out.println("Starting Test 1");

		// create new LinkedList object to test method LinkedList()
		lLI = new LinkedList<Integer>();

		// verify lLI no longer == null
		assertNotEquals(null, lLI);

		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);

		// verify removeFirst() method returns what is expected
		assertEquals("1", lLI.removeFirst().toString());

		// verify contains() method works as expected
		assertEquals(true, lLI.contains(2));

		LinkedList<Integer> lLI2 = new LinkedList<Integer>();

		// test addAll() method
		lLI2.addAll(lLI);

		// verify lLI2 contains what is expected
		assertEquals("2", lLI2.get(0).toString());
		assertEquals("3", lLI2.get(1).toString());
		assertEquals("4", lLI2.get(2).toString());
		assertEquals("5", lLI2.get(3).toString());

		// test set(int index, E element) method
		lLI.set(0, 5);

		// verify that set() method worked as expected
		assertEquals("5", lLI.get(0).toString());

		// verify/test of indexOf() method
		assertEquals(0, lLI.indexOf(5));

		// verify/test of poll() method
		assertEquals("5", lLI.poll().toString());

		// call offerLast() method to add 6 to the end of Linked List
		lLI.offerLast(6);

		// verify value at expected position
		assertEquals(6, lLI.get(3));

		// call and verify pollLast() method
		assertEquals(6, lLI.pollLast());

		// call and verify outcome of removeLastOccurrence() method
		assertEquals(true, lLI.removeLastOccurrence(5));
	}

	/*
	 * This test focuses on alternative branches for the following methods from
	 * LinkedList: remove(), contains(), indexof(), poll(), pollLast(),
	 * removeLastOccurrence()
	 */
	@Test
	void test2() {
		System.out.println("Starting Test 2");

		// create new LinkedList object to test method LinkedList()
		lLI = new LinkedList<Integer>();

		// test and verify alternative branch of remove() method
		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			lLI.remove();
		});

		lLI.add(1);

		// test and verify alternative branch of contains() method
		assertEquals(false, lLI.contains(2));

		// test and verify alternative branch of indexOf() method
		assertEquals(-1, lLI.indexOf(null));

		// add null to linked list
		lLI.add(null);

		// for full coverage call indexOf() method with null already in list
		assertEquals(1, lLI.indexOf(null));

		// reset list to an empty list
		lLI = new LinkedList<Integer>();

		// test and verify alternative branch of poll() method
		assertEquals(null, lLI.poll());

		// test and verify alternative branch of pollLast() method
		assertEquals(null, lLI.pollLast());

		lLI.add(1);

		// test and verify alternative branch of removeLastOccurrence() method
		assertEquals(false, lLI.removeLastOccurrence(null));

		lLI.add(null);

		// test and verify alternative branch of removeLastOccurrence() method
		assertEquals(true, lLI.removeLastOccurrence(null));

		// lastly, for full coverage of removeLastOccurrence() method test method where
		// we look
		// for element in list with elements where the element we are looking for
		// dosen't
		// exsist in list
		assertEquals(false, lLI.removeLastOccurrence(2));

	}

	@Test
	void test3() {
		lLI = new LinkedList<Integer>();
		LinkedList<Integer> emptyList = new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);

		// test the E getLast() method
		assertEquals(5, lLI.getLast());
		assertThrows(NoSuchElementException.class, () -> {
			emptyList.getLast();
		});

		// test the addLast(E e) method
		Integer s1 = lLI.size();
		lLI.addLast(8);

		assertEquals(s1 + 1, lLI.size());

		// test the remove(Object o) method
		assertFalse(lLI.remove(null)); // as we don't have any null element in the linked list
		assertEquals(true, lLI.remove(Integer.valueOf(4))); // remove non null object
		lLI.add(null);
		assertEquals(true, lLI.remove(null));

		// test the get(int index)
		assertEquals("5", lLI.get(3).toString());

		// test the entry(int index) method
		/* remaining */

		// test the E element method
		assertEquals(1, lLI.element());

		// test the offerFirst(E e) method
		lLI.offerFirst(10);
		assertEquals(10, lLI.getFirst());

		// test for pollFirst() method
		int s2 = lLI.size();
		assertEquals(10, lLI.pollFirst());
		assertEquals(s2 - 1, lLI.size());

		assertEquals(null, emptyList.pollFirst());

		// test for removeFirstOccurrence(Object o) method
		int s3 = lLI.size();
		assertEquals(true, lLI.removeFirstOccurrence(Integer.valueOf(3)));
		assertEquals(s3 - 1, lLI.size());

		// test for addBefore(E e, Entry<E> entry) method
		/* remaining */
	}

	@Test
	void test4() {
		System.out.println("Starting Test 4");

		lLI = new LinkedList<Integer>();
		// LinkedList<Integer> emptyList= new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);

		int xyz = lLI.remove(0);
		assertEquals(-1, lLI.indexOf(xyz));

		lLI.indexOf(null);
		assertEquals(-1, lLI.lastIndexOf(1));

		// test the getFirst method
		assertEquals(2, lLI.getFirst()); // test the getFirst method

		assertEquals("5", lLI.removeLast().toString()); // test the removeLast method

		assertEquals(3, lLI.size()); // test the size method

		assertEquals(true, lLI.add(8)); // test add element method

		lLI.addFirst(10);
		assertEquals(10, lLI.getFirst()); // test the addFirst method

		lLI.clear();
		assertEquals(0, lLI.size()); // test the clear method using the size method which has been tested above

		lLI.add(5);
		lLI.add(1, 7);
		assertEquals(7, lLI.get(1)); // test the get method by adding the elements to the list

		//
		lLI.add(8);
		lLI.add(9);

		// test the peek() method by checking the size and the first element twice
		// because of 3 scenarios
		// first: if a person removes the first element and then returns the element
		// second: if a person after getting the first element changes the first value
		// of the linked list
		// third:checking the size of the list because to check whether the peek method
		// has removed the first element or other elements in the list
		assertEquals(4, lLI.size());
		assertEquals(5, lLI.peek());
		assertEquals(4, lLI.size());
		assertEquals(5, lLI.peek());

		// test the peekFirst() method
		assertEquals(4, lLI.size());
		assertEquals(5, lLI.peekFirst());
		assertEquals(4, lLI.size());
		assertEquals(5, lLI.peekFirst());

		// test the peekLast() method
		assertEquals(4, lLI.size());
		assertEquals(9, lLI.peekLast());
		assertEquals(4, lLI.size());
		assertEquals(9, lLI.peekLast());

		// test the push() method
		lLI.push(3);
		assertEquals(3, lLI.peekFirst());
		assertEquals(5, lLI.size());

		lLI.pop();
		assertEquals(5, lLI.peekFirst());
		assertEquals(4, lLI.size());

		// testing the assertEquals() method
		Object[] result = lLI.toArray();
		assertEquals(true, result.getClass().isArray());
		for (int i = 0; i < lLI.size(); i++) {
			assertEquals(lLI.get(i), result[i]);
		}
	}

	@Test
	void test5() {
		System.out.println("Starting Test 5");

		lLI = new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);

		// test the remove() method
		assertEquals(1, lLI.remove());

		// test the offer() method
		assertTrue(lLI.offer(7));
		assertEquals(7, lLI.getLast());

		// test the addAll(index, linkedList) method
		lLI.addAll(2, lLI);
		assertEquals(2, lLI.getFirst());

	}

	@Test
	void test6() {
		System.out.println("Starting Test 6");

		lLI = new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);
		lLI.add(3);
		lLI.add(4);
		lLI.add(5);

		// Test the toArray() method
		Object[] arrrayTest = lLI.toArray();
		Object[] compareArray = { 1, 2, 3, 4, 5 };
		assertArrayEquals(compareArray, arrrayTest);

		// Test the toArray(T[] a) method
		Object[] array1 = new Object[lLI.size()];
		lLI.toArray(array1);
		assertArrayEquals(compareArray, array1);
	}

	// this test will focus on method LastIndexOf()
	@Test
	void test7() {
		System.out.println("Starting Test 7");

		lLI = new LinkedList<Integer>();

		lLI.add(1);

		assertEquals(-1, lLI.lastIndexOf(null));

		lLI.add(null);

		assertEquals(1, lLI.lastIndexOf(null));
		assertEquals(0, lLI.lastIndexOf(1));
	}

	// this test will focus on method toArray()
	@Test
	void test8() {
		System.out.println("Starting Test 8");

		lLI = new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);

		Object[] oA1 = lLI.toArray(new Integer[1]);
		Object[] oA2 = lLI.toArray(new Integer[2]);
		Object[] oA3 = lLI.toArray(new Integer[3]);

		assertEquals(1, oA1[0]);
		assertEquals(2, oA1[1]);
		assertEquals(1, oA2[0]);
		assertEquals(2, oA2[1]);
		assertEquals(1, oA3[0]);
		assertEquals(2, oA3[1]);
	}

	// this test will focus on method add(int index, E element)
	@Test
	void test9() {
		System.out.println("Starting Test 9");

		lLI = new LinkedList<Integer>();

		lLI.add(1);
		lLI.add(2);

		lLI.add(1, 3);

		assertEquals(3, lLI.get(1));
	}

	/*
	 * this test focus on remaining branch of methods peek(), peekFirst(),
	 * peekLast(),LinkedList(LinkedList<E> c), getFirst, addAll(int index,
	 * LinkedList<E> c),remove(int index)
	 */
	@Test
	void test10() {
		System.out.println("Starting Test 10");

		lLI = new LinkedList<Integer>();

		assertEquals(null, lLI.peek());
		assertEquals(null, lLI.peekFirst());
		assertEquals(null, lLI.peekLast());

		// test for LinkedList(LinkedList<E> c) method
		LinkedList<Integer> lLcopy = new LinkedList<Integer>(lLI);
		assertEquals(lLI.size(), lLcopy.size());

		// test the getFirst method
		LinkedList<Integer> lLnew = new LinkedList<Integer>();
		assertThrows(NoSuchElementException.class, () -> {
			lLnew.getFirst();
		});

		// test for addAll(int index, LinkedList<E> c) method
		LinkedList<Integer> lLN = new LinkedList<Integer>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lLN.addAll(-1, lLI);
		});

		// test for remove(int index) method
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lLI.remove(-1);
		});
	}

}
