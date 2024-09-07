package ds.shunting;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ds.shunting.InFixExpression;

class testInFixEvaluate {

	@Test
	void testSimpleAdd() {
		
		InFixExpression inFix = new InFixExpression("3 + 2");
		int expectedResult = 5;
		assertAll(() ->assertEquals("3 + 2",inFix.inFix),
				() ->assertEquals( "3 2 +",inFix.postFix),
				() ->assertEquals(expectedResult , inFix.result)
				
				);		
	}

	@Test
	void testSimpleSubtract() {
		String test = "3 - 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "3 2 -";
		int expectedResult = 1;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
	}
	
	@Test
	void testSimpleMult() {
		String test = "3 * 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "3 2 *";
		int expectedResult = 6;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
	
	}
	
	@Test
	void testSimpleDivide() {
		
		String test = "8 / 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 /";
		int expectedResult = 4;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
	}
	
	@Test
	void testAddTwice() {
		
		String test = "8 + 2 + 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 + 4 +";
		int expectedResult = 14;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
		
	}
	@Test
	void testMultTwice() {
		
		String test = "8 * 2 * 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 * 4 *";
		int expectedResult = 64;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
		
			
	}
	@Test
	void testAddThenSub() {
		
		String test = "8 + 2 - 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 + 4 -";
		int expectedResult = 6;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);	
	
	}
	@Test
	void testAddThenMult() {
		
		String test = "8 + 2 * 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 4 * +";
		int expectedResult = 16;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);	
		
		
	}
	@Test
	void testSubThenDiv() {
		
		String test = "8 - 4 / 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 2 / -";
		int expectedResult = 6;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);	
		
	}
	
	@Test
	void testSubThenDivThenAdd () {
		
		String test = "8 - 4 / 2 + 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 2 / - 5 +";
		int expectedResult = 11;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);			
			
	}
	
	@Test
	void testSubThenAddThenMult () {
		
		String test = "8 - 4 + 2 * 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 - 2 5 * +";
		int expectedResult = 14;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);			
				
	}
	@Test
	void testMultThenAddThenMult () {
		
		String test = "8 * 4 + 2 * 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * +";
		int expectedResult = 42;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
				
	}
	
	@Test
	void testMultThenAddThenMultThenAdd () {
		
		String test = "8 * 4 + 2 * 5 + 7";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * + 7 +";
		int expectedResult = 49;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);		
		
			
	}
	
	@Test
	void testMultThenAddThenMultThenAddTheMult () {
		
		String test = "8 * 4 + 2 * 5 + 7 * 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * + 7 2 * +";
		int expectedResult = 56;
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix),
				() ->assertEquals(expectedResult, inFix.result )
				
				);	
		
		
	}
}
