import java.util.Arrays;
import java.util.Stack;


public class ExpressionsStack {

	public static void main(String args[]){
		String sa_expression = "(1+((2+3)*(4*5)))" ;
		
		char[] expression = sa_expression.toCharArray();


		Stack<Double> operands  = new Stack<Double>();
		Stack<Character> operators  = new Stack<Character>();

		for(int i = 0; i < expression.length; i++)
		{
			if(expression[i] == ' ' || expression[i] == '(')
			{
				continue;
				
			}else if(expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/')
			{
				operators.push(expression[i]);
				
			}else if(expression[i] == ')')
			{
				double y = operands.pop();
				double x = operands.pop();
				
				char ops = operators.pop();
				if(ops == '+')
					operands.push(x+y);
				else if(ops == '-')
					operands.push(x-y);
				else if(ops == '*')
					operands.push(x*y);
				else if(ops == '/')
					operands.push(x/y);
			}
			else{
				operands.push(Double.parseDouble(expression[i]+""));
			}
		}
		System.out.println("operands: "+ operands);
		System.out.println("operators: "+ operators);
		
		
	}
}
