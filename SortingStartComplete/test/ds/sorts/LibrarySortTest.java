package ds.sorts;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ds.sorts.Sorts;
import ds.sorts.Sorts.Sort;



class LibrarySortTest { 

	public static Sort<Integer> sort = (Sort<Integer>)Sorts::<Integer>librarySort;
	
	public static ArrayList<Integer> integer1024;
	public static ArrayList<Integer> integer1025;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		integer1024 = new ArrayList<>();
		integer1025 = new ArrayList<>();
		for (int i = 0; i < 1024; i++) {			
			integer1024.add(i);
			integer1025.add(i);
		}
		
	}
	
	@Test
	void emptyList() {
		
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		sort.sortList(test);
		
		assertTrue(test.isEmpty());
	}
	
	@Test
	void singleItem() {
		Integer array[] = {12}; 
		
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test);
		assertAll(()-> assertEquals(12 ,test.get(0).intValue())  );   
	}
	
	@Test
	void twoItems() {
		Integer array[] = {25, 12}; 
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test);
		
		assertAll(()-> assertEquals(12 ,test.get(0).intValue()),
				  ()-> assertEquals(25 ,test.get(1).intValue()));
	}

	@Test
	void tenItems() {
		// even number of items
		Integer array[] = {99, 25, 12 , 33, 13, 66, 19, 78, 85, 5}; 
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test); 
		
		assertAll(()-> assertEquals(5 , test.get(0).intValue()),
				  ()-> assertEquals(12 ,test.get(1).intValue()),
				  ()-> assertEquals(13 ,test.get(2).intValue()),
				  ()-> assertEquals(19 ,test.get(3).intValue()),
				  ()-> assertEquals(25 ,test.get(4).intValue()),
				  ()-> assertEquals(33 ,test.get(5).intValue()),
				  ()-> assertEquals(66 ,test.get(6).intValue()),
				  ()-> assertEquals(78 ,test.get(7).intValue()),
				  ()-> assertEquals(85 ,test.get(8).intValue()),
				  ()-> assertEquals(99 ,test.get(9).intValue()));
	}
	
	
	@Test
	void elevenItems() {
		// even number of items
		Integer array[] = {99, 25, 12 , 33, 13, 66, 19, 78, 85, 5, 105}; 
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test);
				
		assertAll(()-> assertEquals(5 , test.get(0).intValue()),
				  ()-> assertEquals(12 ,test.get(1).intValue()),
				  ()-> assertEquals(13 ,test.get(2).intValue()),
				  ()-> assertEquals(19 ,test.get(3).intValue()),
				  ()-> assertEquals(25 ,test.get(4).intValue()),
				  ()-> assertEquals(33 ,test.get(5).intValue()),
				  ()-> assertEquals(66 ,test.get(6).intValue()),
				  ()-> assertEquals(78 ,test.get(7).intValue()),
				  ()-> assertEquals(85 ,test.get(8).intValue()),
				  ()-> assertEquals(99 ,test.get(9).intValue()),
				  ()-> assertEquals(105 ,test.get(10).intValue()));
	}
	
	
	@Test
	void reverseOrder() {
		// even number of items
		Integer array[] = {105, 99, 85 , 78, 66, 33, 25, 19, 13, 12, 5}; 
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test);
				
		assertAll(()-> assertEquals(5 , test.get(0).intValue()),
				  ()-> assertEquals(12 ,test.get(1).intValue()),
				  ()-> assertEquals(13 ,test.get(2).intValue()),
				  ()-> assertEquals(19 ,test.get(3).intValue()),
				  ()-> assertEquals(25 ,test.get(4).intValue()),
				  ()-> assertEquals(33 ,test.get(5).intValue()),
				  ()-> assertEquals(66 ,test.get(6).intValue()),
				  ()-> assertEquals(78 ,test.get(7).intValue()),
				  ()-> assertEquals(85 ,test.get(8).intValue()),
				  ()-> assertEquals(99 ,test.get(9).intValue()),
				  ()-> assertEquals(105 ,test.get(10).intValue()));
	}
	
	@Test
	void inOrder() {
		// even number of items
		Integer array[] = {5, 12, 13 , 19, 25, 33, 66, 78, 85, 99, 105}; 
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(array));
		sort.sortList(test);
				
		assertAll(()-> assertEquals(5 , test.get(0).intValue()),
				  ()-> assertEquals(12 ,test.get(1).intValue()),
				  ()-> assertEquals(13 ,test.get(2).intValue()),
				  ()-> assertEquals(19 ,test.get(3).intValue()),
				  ()-> assertEquals(25 ,test.get(4).intValue()),
				  ()-> assertEquals(33 ,test.get(5).intValue()),
				  ()-> assertEquals(66 ,test.get(6).intValue()),
				  ()-> assertEquals(78 ,test.get(7).intValue()),
				  ()-> assertEquals(85 ,test.get(8).intValue()),
				  ()-> assertEquals(99 ,test.get(9).intValue()),
				  ()-> assertEquals(105 ,test.get(10).intValue()));
	}
	
	@Test
	void largeTestEven() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1024);
		Collections.shuffle(test);		
		sort.sortList(test);
		
		assertArrayEquals(integer1024.toArray(), test.toArray());
		
		
	}
	

	@Test
	void largeTestOdd() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1025);
		Collections.shuffle(test);		
		sort.sortList(test);
		
		assertArrayEquals(integer1025.toArray(), test.toArray());
		
		
	}
	
	@Test
	void largeTestEvenInorder() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1024);
		sort.sortList(test);
		
		assertArrayEquals(integer1024.toArray(), test.toArray());
		
		
	}
	

	@Test
	void largeTestOddInorder() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1025);
		sort.sortList(test);
		
		assertArrayEquals(integer1025.toArray(), test.toArray());
		
		
	}
	
	@Test
	void largeTestEvenReverseOrder() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1024);
		Collections.reverse(test);
		sort.sortList(test);
		assertArrayEquals(integer1024.toArray(), test.toArray());
		
		
	}
	

	@Test
	void largeTestOddReverseOrder() {
	
		
		ArrayList<Integer> test = new ArrayList<>(integer1025);
		Collections.reverse(test);
		sort.sortList(test);		
		assertArrayEquals(integer1025.toArray(), test.toArray());
		
		
	}
}
