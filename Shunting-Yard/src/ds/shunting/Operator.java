package ds.shunting;

public enum Operator {

	ADD(10,"+") {

		@Override
		int evaluate(int operrand1, int operand2) {

			return operrand1 + operand2;
		}
	}

	,
	
	MODULO(20, "%"){

		@Override
		int evaluate(int operrand1, int operand2) {
			return operrand1 % operand2;
		}
		
	}
	
	,

	SUBTRACT(10,"-") {
		@Override
		int evaluate(int operrand1, int operand2) {

			return operrand1 - operand2;
		}
	}

	,
	DIVIDE(20,"/") {
		@Override
		int evaluate(int operrand1, int operand2) {

			return operrand1 / operand2;
		}
	},
	MULTIPLY(20,"*") {
		@Override
		int evaluate(int operrand1, int operand2) {
		
			return operrand1 * operand2;
		}
	},
	NOT_OPERATOR(100,"NOT_OPERATOR") {
		@Override
		int evaluate(int operrand1, int operand2) {
		
			return 0;
		}
	};

	public final int precedence;
	public final String symbol;
	
	private Operator(int precedence, String symbol) {
		this.precedence = precedence;
		this.symbol = symbol;
		
	}
	
	abstract int evaluate(int operrand1, int operand2);

	public static Operator getEnumFromSymbol(String symbol)
	{
		switch (symbol) {
		case "+":			
			return ADD;
		case "-":			
			return SUBTRACT;
		case "/":			
			return DIVIDE;
		case "*":			
			return MULTIPLY;
			
		case "%":
			return MODULO;
			
		default:
			return NOT_OPERATOR;
		}
	}
	
	public boolean notGreater(Operator op)
	{
		return this.precedence <= op.precedence;
	}
}
