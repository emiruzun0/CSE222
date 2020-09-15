import java.util.Stack;
/**
 * This class evaluates the postfix expressions.
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class Postfix {
		  
		  /**
	     * This character controls the character that is operand or not.
	     * @param c Given character
	     * @return Returns true if the character is not operator.
	     */
	    static Boolean isOperator(char c) 
	    { 
	        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')');
	    } 
	  
	    /**
	     * This method find the result of postfix expression.
	     * @param Stack  Keeps the elements
	     * @param expression Given expression
	     * @return Returns the result of expression.
	     */
	    public static Double evaluatePostfix(Stack<Double> Stack,String expression) 
	    { 
	    	//Base case is if the expression doesn't have more elements then returns the stack which is answer
	    	if (expression.length() < 1)
		        return Stack.peek() ;
	        
	         int spaceIndex = expression.indexOf(" ");
	    	 if(spaceIndex == -1) {
	    		  double o1 = Stack.peek(); 
	                Stack.pop(); 
	                double o2 = Stack.peek(); 
	                Stack.pop(); 
	  
	                //I would like to specify that I firstly wrote o2 and o1.
	                //Because when we pop two numbers, we firstly put the last pop element which is o2
	                switch (expression.charAt(0)) { 
		                case '+': 
		                    Stack.push(o2 + o1); 
		                    break; 
		                case '-': 
		                    Stack.push(o2 - o1); 
		                    break; 
		                case '*': 
		                    Stack.push(o2 * o1); 
		                    break; 
		                case '/': 
		                    Stack.push(o2 / o1); 
		                    break; 
	                } 
	                return Stack.peek();
	    	 }
	    	 
	    	 String firstWord = expression.substring(0, spaceIndex);
		  
	        //Check the element that if is operand push to the stack.
		    if (!isOperator(firstWord.charAt(0)))
                Stack.push(Double.parseDouble(firstWord)); //String to double
		    else { 
		  	  
		    	 //If the element is not operand than pop two element and process with incoming operator
                double o1 = Stack.peek(); 
                Stack.pop(); 
                double o2 = Stack.peek(); 
                Stack.pop(); 
  
                //I would like to specify that I firstly wrote o2 and o1.
                //Because when we pop two numbers, we firstly put the last pop element which is o2
                switch (firstWord.charAt(0)) { 
                case '+': 
                    Stack.push(o2 + o1); 
                    break; 
                case '-': 
                    Stack.push(o2 - o1); 
                    break; 
                case '*': 
                    Stack.push(o2 * o1); 
                    break; 
                case '/': 
                    Stack.push(o2 / o1); 
                    break; 
                } 
            } 
	  	  
		    //Call recursive method with first index of expression 
	        return evaluatePostfix(Stack,expression.substring(spaceIndex + 1));
	    } 
	  
	    /**
	     * @param args String arguments
	     */
	    public static void main(String[] args) 
	    { 
	    	String expression = "8 7 * 9 + 3 / 4 -";
	        Stack<Double> Stack = new Stack<Double>(); 
	        System.out.println("The postfix value is : " + evaluatePostfix(Stack,expression)); 
	    } 
}