package ds.shunting;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ds.shunting.InFixExpression;

class testInFixToPostFix {

	@Test
	void testSimpleAdd() {
		
		InFixExpression inFix = new InFixExpression("3 + 2");
		
		assertAll(() ->assertEquals("3 + 2",inFix.inFix),
				() ->assertEquals( "3 2 +",inFix.postFix)
				
				
				);		
	}

	@Test
	void testSimpleSubtract() {
		String test = "3 - 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "3 2 -";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				
				
				);		
	}
	
	@Test
	void testSimpleMult() {
		String test = "3 * 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "3 2 *";
		
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				
				
				);		
	
	}
	
	@Test
	void testSimpleDivide() {
		
		String test = "8 / 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 /";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);		
	}
	
	@Test
	void testAddTwice() {
		
		String test = "8 + 2 + 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 + 4 +";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);		
		
	}
	@Test
	void testMultTwice() {
		
		String test = "8 * 2 * 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 * 4 *";
	
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);		
		
			
	}
	@Test
	void testAddThenSub() {
		
		String test = "8 + 2 - 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 + 4 -";
		
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);	
	
	}
	@Test
	void testAddThenMult() {
		
		String test = "8 + 2 * 4";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 2 4 * +";
		
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				
				);	
		
		
	}
	@Test
	void testSubThenDiv() {
		
		String test = "8 - 4 / 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 2 / -";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);	
		
	}
	
	@Test
	void testSubThenDivThenAdd () {
		
		String test = "8 - 4 / 2 + 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 2 / - 5 +";
	
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);			
			
	}
	
	@Test
	void testSubThenAddThenMult () {
		
		String test = "8 - 4 + 2 * 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 - 2 5 * +";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);			
				
	}
	@Test
	void testMultThenAddThenMult () {
		
		String test = "8 * 4 + 2 * 5";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * +";
	
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);		
				
	}
	
	@Test
	void testMultThenAddThenMultThenAdd () {
		
		String test = "8 * 4 + 2 * 5 + 7";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * + 7 +";
	
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);		
		
			
	}
	
	@Test
	void testMultThenAddThenMultThenAddTheMult () {
		
		String test = "8 * 4 + 2 * 5 + 7 * 2";
		InFixExpression inFix = new InFixExpression(test);
		String postFix = "8 4 * 2 5 * + 7 2 * +";
		
		
		assertAll(() ->assertEquals(test, inFix.inFix),
				() ->assertEquals(postFix,inFix.postFix)
				);	
		
		
	}
}
