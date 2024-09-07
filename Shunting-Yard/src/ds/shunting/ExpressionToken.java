package ds.shunting;

public class ExpressionToken {	
	
	public final int value;
	public final Operator operator;
		
	
	@Override
	public String toString() {
		if(operator == Operator.NOT_OPERATOR)
		{
			return String.format("%d", value); 
		}
		else
		{ 
			return operator.symbol;
		}
		
	}

	public ExpressionToken(String token) {
		super();
		this.operator = Operator.getEnumFromSymbol(token);
		if(this.operator == Operator.NOT_OPERATOR)
		{
			this.value = Integer.parseInt(token);
		}
		else
		{
			this.value = 0;
		}
	
	}
	

}
