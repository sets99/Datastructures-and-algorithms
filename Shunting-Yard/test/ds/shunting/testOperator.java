package ds.shunting;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ds.shunting.Operator;

class testOperator {

	@Test
	void testGetEnumNotOp() {
		
		Operator test = Operator.getEnumFromSymbol("55");
		int sum = test.evaluate(5 , 8);
		
		assertAll(() ->assertEquals(Operator.NOT_OPERATOR, test),
				() ->assertEquals(0, sum)
				
				);
		
		
	}
	@Test
	void testGetEnumAdd() {
		
		Operator test = Operator.getEnumFromSymbol("+");
		int sum = test.evaluate(5 , 8);
		
		assertAll(() ->assertEquals(Operator.ADD, test),
				() ->assertEquals(13, sum)
				
				);
		
		
	}
	
	@Test
	void testGetEnumModulo() {
		
		Operator test = Operator.getEnumFromSymbol("%");
		int modulo = test.evaluate(8 , 5);
		
		assertAll(() ->assertEquals(Operator.MODULO, test),
				() ->assertEquals(3, modulo)
				
				);
		
		
	}
	
	

	@Test
	void testGetEnumDivide() {
		
		Operator test = Operator.getEnumFromSymbol("/");
		int quotient = test.evaluate(20 , 10);
		
		assertAll(() ->assertEquals(Operator.DIVIDE, test),
				() ->assertEquals(2, quotient)
				
				);
		
		
	}
	
	@Test
	void testGetEnumSubtract() {
		
		Operator test = Operator.getEnumFromSymbol("-");
		int diff = test.evaluate(5 , 8);
		
		assertAll(() ->assertEquals(Operator.SUBTRACT, test),
				() ->assertEquals(-3, diff)
				
				);
		
		
	}
	@Test
	void testGetEnumMult() {
		
		Operator test = Operator.getEnumFromSymbol("*");
		int product = test.evaluate(5 , 8);
		
		assertAll(() ->assertEquals(Operator.MULTIPLY, test),
				() ->assertEquals(40, product)
				
				);
		
		
	}
	
	
	@Test
	void testNotGreater() {
				
		
		assertAll(() ->assertTrue(Operator.DIVIDE.notGreater(Operator.MULTIPLY)),
				() ->assertFalse(Operator.DIVIDE.notGreater(Operator.ADD)),
				() ->assertFalse(Operator.DIVIDE.notGreater(Operator.SUBTRACT)),
				() ->assertTrue(Operator.MULTIPLY.notGreater(Operator.DIVIDE)),
				() ->assertFalse(Operator.MULTIPLY.notGreater(Operator.ADD)),
				() ->assertFalse(Operator.MULTIPLY.notGreater(Operator.SUBTRACT)),
				() ->assertTrue(Operator.SUBTRACT.notGreater(Operator.ADD)),
				() ->assertTrue(Operator.SUBTRACT.notGreater(Operator.DIVIDE)),
				() ->assertTrue(Operator.SUBTRACT.notGreater(Operator.MULTIPLY)),
				() ->assertTrue(Operator.ADD.notGreater(Operator.SUBTRACT)),
				() ->assertTrue(Operator.ADD.notGreater(Operator.DIVIDE)),
				() ->assertTrue(Operator.ADD.notGreater(Operator.MULTIPLY))
				
				
				);
		
		
	}
}
