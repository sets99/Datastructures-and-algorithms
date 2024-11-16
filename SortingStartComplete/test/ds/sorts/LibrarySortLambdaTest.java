package ds.sorts;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ds.sorts.Employee;
import ds.sorts.EmployeeType;
import ds.sorts.Sorts;
import ds.sorts.Sorts.SortCompare;



class LibrarySortLambdaTest { 

	public static SortCompare<Employee> sort = (SortCompare<Employee>)Sorts::<Employee>librarySort;
	public static ArrayList<Employee> employees1024;
	public static ArrayList<Employee> employees1025;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		int typeCount = EmployeeType.values().length;
		employees1024 = new ArrayList<>();
		employees1025 = new ArrayList<>();
		for (int i = 0; i < 1024; i++) {			
			employees1024.add(new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,String.format("%010d", i), ""+i));
			employees1025.add(new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,String.format("%010d", i), ""+i));
		}
		
	}
	
	
	@Test
	void emptyList() {
		
		
		ArrayList<Employee> test = new ArrayList<Employee>();
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		
		assertTrue(test.isEmpty());
	}
	
	@Test
	void singleItem() {
		
		int array[] = {12}; 
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		assertAll(()-> assertEquals(test.get(0) ,employees1024.get(array[0])) );   
	}
	
	@Test
	void twoItems() {
		
		int array[] = {25,12}; 
		int inorderArray[] = {12,25}; 
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
			assertAll(()-> assertEquals(test.get(0) ,employees1024.get(inorderArray[0])),
					()-> assertEquals(test.get(1) ,employees1024.get(inorderArray[1])));   
	}

	@Test
	void tenItems() {
		
		int array[] = {99, 25, 12 , 33, 13, 66, 19, 78, 85, 5}; 
		int inorderArray[] = {5, 12, 13, 19, 25, 33, 66, 78, 85, 99};
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
			assertAll(()-> assertEquals(test.get(0) ,employees1024.get(inorderArray[0])),
					()-> assertEquals(test.get(1) ,employees1024.get(inorderArray[1])),
					()-> assertEquals(test.get(2) ,employees1024.get(inorderArray[2])),
					()-> assertEquals(test.get(3) ,employees1024.get(inorderArray[3])),
					()-> assertEquals(test.get(4) ,employees1024.get(inorderArray[4])),
					()-> assertEquals(test.get(5) ,employees1024.get(inorderArray[5])),
					()-> assertEquals(test.get(6) ,employees1024.get(inorderArray[6])),
					()-> assertEquals(test.get(7) ,employees1024.get(inorderArray[7])),
					()-> assertEquals(test.get(8) ,employees1024.get(inorderArray[8])),
					()-> assertEquals(test.get(9) ,employees1024.get(inorderArray[9]))
					
					);   	
	}
	
	
	@Test
	void elevenItems() {
		
		int array[] = {99, 25, 12 , 33, 13, 66, 105, 19, 78, 85, 5}; 
		int inorderArray[] = {5, 12, 13, 19, 25, 33, 66, 78, 85, 99, 105};
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
			assertAll(()-> assertEquals(test.get(0) ,employees1024.get(inorderArray[0])),
					()-> assertEquals(test.get(1) ,employees1024.get(inorderArray[1])),
					()-> assertEquals(test.get(2) ,employees1024.get(inorderArray[2])),
					()-> assertEquals(test.get(3) ,employees1024.get(inorderArray[3])),
					()-> assertEquals(test.get(4) ,employees1024.get(inorderArray[4])),
					()-> assertEquals(test.get(5) ,employees1024.get(inorderArray[5])),
					()-> assertEquals(test.get(6) ,employees1024.get(inorderArray[6])),
					()-> assertEquals(test.get(7) ,employees1024.get(inorderArray[7])),
					()-> assertEquals(test.get(8) ,employees1024.get(inorderArray[8])),
					()-> assertEquals(test.get(9) ,employees1024.get(inorderArray[9])),
					()-> assertEquals(test.get(10) ,employees1024.get(inorderArray[10]))
					
					);   	
	}
	
	
	@Test
	void reverseOrder() {
		
		int array[] = {105, 99, 85 , 78, 66, 33, 25, 19, 13, 12, 5}; 
		int inorderArray[] = {5, 12, 13, 19, 25, 33, 66, 78, 85, 99, 105};
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
			assertAll(()-> assertEquals(test.get(0) ,employees1024.get(inorderArray[0])),
					()-> assertEquals(test.get(1) ,employees1024.get(inorderArray[1])),
					()-> assertEquals(test.get(2) ,employees1024.get(inorderArray[2])),
					()-> assertEquals(test.get(3) ,employees1024.get(inorderArray[3])),
					()-> assertEquals(test.get(4) ,employees1024.get(inorderArray[4])),
					()-> assertEquals(test.get(5) ,employees1024.get(inorderArray[5])),
					()-> assertEquals(test.get(6) ,employees1024.get(inorderArray[6])),
					()-> assertEquals(test.get(7) ,employees1024.get(inorderArray[7])),
					()-> assertEquals(test.get(8) ,employees1024.get(inorderArray[8])),
					()-> assertEquals(test.get(9) ,employees1024.get(inorderArray[9])),
					()-> assertEquals(test.get(10) ,employees1024.get(inorderArray[10]))
					
					);   	
	}
	
	@Test
	void inOrder() {
		int array[] = {5, 12, 13, 19, 25, 33, 66, 78, 85, 99, 105};
		int inorderArray[] = {5, 12, 13, 19, 25, 33, 66, 78, 85, 99, 105};
		ArrayList<Employee> test = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			test.add(employees1024.get(array[i]));
		}
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
			assertAll(()-> assertEquals(test.get(0) ,employees1024.get(inorderArray[0])),
					()-> assertEquals(test.get(1) ,employees1024.get(inorderArray[1])),
					()-> assertEquals(test.get(2) ,employees1024.get(inorderArray[2])),
					()-> assertEquals(test.get(3) ,employees1024.get(inorderArray[3])),
					()-> assertEquals(test.get(4) ,employees1024.get(inorderArray[4])),
					()-> assertEquals(test.get(5) ,employees1024.get(inorderArray[5])),
					()-> assertEquals(test.get(6) ,employees1024.get(inorderArray[6])),
					()-> assertEquals(test.get(7) ,employees1024.get(inorderArray[7])),
					()-> assertEquals(test.get(8) ,employees1024.get(inorderArray[8])),
					()-> assertEquals(test.get(9) ,employees1024.get(inorderArray[9])),
					()-> assertEquals(test.get(10) ,employees1024.get(inorderArray[10]))
					
					);   	
	}
	
	@Test
	void largeTestEven() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1024);
		Collections.shuffle(test);
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		assertArrayEquals(employees1024.toArray(), test.toArray());
		
		
	}
	

	@Test
	void largeTestOdd() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1025);
		Collections.shuffle(test);
		
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		assertArrayEquals(employees1025.toArray(), test.toArray());
		
		
	}
	
	@Test
	void largeTestEvenInorder() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1024);
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		
		assertArrayEquals(employees1024.toArray(), test.toArray());
		
		
	}
	

	@Test
	void largeTestOddInorder() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1025);
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		
		assertArrayEquals(employees1025.toArray(), test.toArray());
		
		
	}
	
	@Test
	void largeTestEvenReverseOrder() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1024);
		Collections.reverse(test);
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		assertArrayEquals(employees1024.toArray(), test.toArray());
		
		 
	}
	

	@Test
	void largeTestOddReverseOrder() {
	
		
		ArrayList<Employee> test = new ArrayList<>(employees1025);
		Collections.reverse(test);
		sort.sortList(test, (e1,e2) -> {return e1.getID().compareTo(e2.getID());});
		assertArrayEquals(employees1025.toArray(), test.toArray());
		
		
	}
}
