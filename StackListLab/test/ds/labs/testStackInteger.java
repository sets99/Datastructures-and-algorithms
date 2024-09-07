package ds.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class testStackInteger {

	@Test
	void testSizeOnEmptyStack() {

		StackList<Integer> test = new StackList<Integer>();
		int actual = test.size();
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	void testSizeOnStackAfterPush() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(0);
		int actual = test.size();
		int expected = 1;
		assertEquals(expected, actual);

	}

	@Test
	void testSizeOnStackAfter2PushPop() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(0);
		test.push(1);
		test.pop();
		int actual = test.size();
		int expected = 1;
		assertEquals(expected, actual);

	}

	@Test
	void testPeekOnEmptyStack() {

		StackList<Integer> test = new StackList<Integer>();

		assertThrows(EmptyStackException.class, () -> {
			test.peek();
		});

	}

	@Test
	void testPeekOnStackAfter2PushPop() {
		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		test.push(11);
		test.pop();
		int actual = test.peek();
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	void testPeekOnStackAfterPush() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		int actual = test.peek();
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	void testPeekOnStackAfterPushPop() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		test.pop();
		assertThrows(EmptyStackException.class, () -> {
			test.peek();
		});
	}

	@Test
	void testPopOnEmptyStack() {

		StackList<Integer> test = new StackList<Integer>();

		assertThrows(EmptyStackException.class, () -> {
			test.pop();
		});

	}

	@Test
	void testPopOnStackAfter2PushPop() {
		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		test.push(11);
		test.pop();
		int actual = test.pop();
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	void testPopOnStackAfterPush() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		int actual = test.pop();
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	void testPopOnStackAfterPushPop() {

		StackList<Integer> test = new StackList<Integer>();
		test.push(10);
		test.pop();
		assertThrows(EmptyStackException.class, () -> {
			test.pop();
		});
	}

	@Test
	void testPushUntilResize() {

		StackList<Integer> test = new StackList<Integer>();
		for (int i = 10; i < 150; i++) {
			test.push(i);

		}
		test.push(150);
		int actual = test.pop();
		int expected = 150;
		assertEquals(expected, actual);
	}

	@Test
	public void testPushPopAndSizeTogether() {
		StackList<Integer> test = new StackList<Integer>();
		// Push two elements
		test.push(5);
		test.push(10);

		// Use assertAll to group multiple assertions
		assertAll("Stack state after pushing elements",
				() -> assertEquals(2, test.size(), "Size should be 2 after pushing two elements"),
				() -> assertEquals(10, test.peek(), "Top element should be 10"),
				() -> assertFalse(test.isEmpty(), "Stack should not be empty after pushing elements"));

		// Pop one element and check again
		test.pop();

		// Another assertAll after popping
		assertAll("Stack state after popping one element",
				() -> assertEquals(1, test.size(), "Size should be 1 after popping one element"),
				() -> assertEquals(5, test.peek(), "Top element should now be 5"),
				() -> assertFalse(test.isEmpty(), "Stack should not be empty after popping one element"));
	}

	@Test
	public void testPopOnEmptyStack2() {
		StackList<Double> test = new StackList<Double>();
		// Use assertAll to verify both exception and size
		assertAll("Pop on empty stack",
				() -> assertThrows(EmptyStackException.class, () -> test.pop(), "Should throw EmptyStackException"),
				() -> assertEquals(0, test.size(), "Size should be 0 after attempting to pop on an empty stack"));
	}
}
