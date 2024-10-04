package ds.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;


class testStackDouble {

	@Test
	void testSizeOnEmptyStack() {
		
		StackList2<Double>  test = new StackList2<Double> ();
		int actual =  test.size();
		int expected = 0;
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSizeOnStackAfterPush() {
		
		StackList2<Double>  test = new StackList2<Double> ();
		test.push(0.0);
		int actual =  test.size();
		int expected = 1;
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSizeOnStackAfter2PushPop() {
		
		StackList2<Double>  test = new StackList2<Double> ();
		test.push(0.0);
		test.push(1.0);
		test.pop();
		int actual =  test.size();
		int expected = 1;
		assertEquals(expected, actual, .001);
		
	}
	
	@Test
	void testPeekOnEmptyStack() {
		
		StackList2<Double>  test = new StackList2<Double> ();
		
		assertThrows(EmptyStackException.class, () -> { test.peek();});	  		
		
		
	}
	
	
	@Test
	void testPeekOnStackAfter2PushPop() {		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		test.push(11.0);
		test.pop();
		double actual =  test.peek();
		double expected = 10;
		assertEquals(expected, actual, .001);		
	}
	
	@Test
	void testPeekOnStackAfterPush() {
		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		double actual =  test.peek();
		double expected = 10;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPeekOnStackAfterPushPop() {
		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		test.pop();
		assertThrows(EmptyStackException.class, () -> { test.peek();});	  			
	}
	
	@Test
	void testPopOnEmptyStack() {
		
		StackList2<Double>  test = new StackList2<Double> ();
		
		assertThrows(EmptyStackException.class, () -> { test.pop();});		
		
	}
	
	@Test
	void testPopOnStackAfter2PushPop() {		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		test.push(11.0);
		test.pop();
		double actual =  test.pop();
		double expected = 10;
		assertEquals(expected, actual, .001);		
	}
	
	@Test
	void testPopOnStackAfterPush() {
		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		double actual =  test.pop();
		double expected = 10;
		assertEquals(expected, actual, .001);		
	}
	
	@Test
	void testPopOnStackAfterPushPop() {
		
		StackList2<Double> test = new StackList2<Double> ();
		test.push(10.0);
		test.pop();
		assertThrows(EmptyStackException.class, () -> { test.pop();});	  			
	}
	
	
	@Test
	void testPushUntilResize() {
		
		StackList2<Double> test = new StackList2<Double> ();
		for (int i = 10; i < 150; i++) {
			test.push((double)i);
			
		}	
		test.push(150.0);			
		double actual =  test.pop();
		double expected = 150;
		assertEquals(expected, actual, .001);		
	}
	
	 @Test
	    public void testPushPopAndSizeTogether() {
		    StackList2<Double> test = new StackList2<Double> ();
	        // Push two elements
		    test.push(5.5);
		    test.push(10.1);

	        // Use assertAll to group multiple assertions
	        assertAll("Stack state after pushing elements",
	            () -> assertEquals(2, test.size(), "Size should be 2 after pushing two elements"),
	            () -> assertEquals(10.1, test.peek(), 0.001, "Top element should be 10.1"),
	            () -> assertFalse(test.isEmpty(), "Stack should not be empty after pushing elements")
	        );

	        // Pop one element and check again
	        test.pop();

	        // Another assertAll after popping
	        assertAll("Stack state after popping one element",
	            () -> assertEquals(1, test.size(), "Size should be 1 after popping one element"),
	            () -> assertEquals(5.5, test.peek(), 0.001, "Top element should now be 5.5"),
	            () -> assertFalse(test.isEmpty(), "Stack should not be empty after popping one element")
	        );
	    }

	    @Test
	    public void testPopOnEmptyStack2() {
	    	StackList2<Double> test = new StackList2<Double> ();
	        // Use assertAll to verify both exception and size
	        assertAll("Pop on empty stack",
	            () -> assertThrows(EmptyStackException.class, () -> test.pop(), "Should throw EmptyStackException"),
	            () -> assertEquals(0, test.size(), "Size should be 0 after attempting to pop on an empty stack")
	        );
	    }
}
