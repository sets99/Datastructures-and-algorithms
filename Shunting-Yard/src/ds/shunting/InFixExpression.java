package ds.shunting;

import java.util.Queue;

public class InFixExpression {
	
	public final String postFix;
	public final String inFix;
	public final int result;
		
	/**
	 * Takes in an the infix expression does not expect parenthesis. 
	 * Handles only Division, +, -, *
	 * @param String the infix expression
	 *  Example 4 + 5 * 7
	 * 	 
	 * */
	public InFixExpression(String expression) {
		super();
		this.inFix = expression;
		this.postFix = convertToPostFix();
		this.result = evaluate();
	}
	
	/**
	 * Converts the infix expression to a Queue of ExpressionTokens in Postfix order.
	 * @param none
	 * @return A Queue of ExpressionTokens 
	 */
	private Queue<ExpressionToken> postFixQueue()
	{
		QueueList<ExpressionToken> queue = new QueueList<>();
		StackList<Character> stack = new StackList<>();
		
		for(int i = 0; i < inFix.length(); i++) {
			char c = inFix.charAt(i);
			
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
				if(stack.isEmpty() || !Operator.getEnumFromSymbol(String.valueOf(c)).notGreater(stack.peek().getEnumFromSymbol)) {
					stack.push(c);
				}
			
				
				else {
					while(Operator.getEnumFromSymbol(String.valueOf(c)).precedence <= stack.peek().precedence) {
						queue.enqueue(new ExpressionToken(stack.pop()));
					}
					
					stack.push(c);
				}
			}
			
			else {
				queue.enqueue(new ExpressionToken(String.valueOf(c)));
			}
		}
		
		while(!stack.isEmpty()) {
			queue.enqueue(new ExpressionToken(stack.pop()));
		}
		
		return queue;
	}
	
	
	

	private String convertToPostFix()
	{
		QueueList<ExpressionToken> queue = postFixQueue();
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty())
		{
			sb.append(queue.dequeue().toString());
			sb.append(" ");
		}		
		return sb.toString().trim();
	}
	
	/**
	 * Evaluates the infix expression to its final result.
	 * @param none
	 * @return A integer that is the final result of the expression 
	 */
	
	private int evaluate()
	{
		StackList<Integer> numberstack = new StackList<>();
		int operand2;
		int operand1;
		int result;
		
		for(int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
				operand2 = numberstack.pop();
				operand1 = numberstack.pop();
				Operator operator = Operator.getEnumFromSymbol(String.valueOf(c));
				result = operator.evaluate(operand1, operand2);
				numberstack.push(result);
			}
			
			else {
				numberstack.push(Integer.decode(String.valueOf(c)));
			}
			
		}
		
		return numberstack.pop();
		
		
		
		
		
	}
	
	@Override
	public String toString() {
		
		return String.format("InFix %s PostFix %s Evaluated %d", inFix,postFix,result);
	}

}
