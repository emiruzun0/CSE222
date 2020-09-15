import java.util.Stack;

/**
 * This class evaluates the prefix expressions.
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class Prefix {
		  
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
	     * This method find the result of prefix expression.
	     * @param Stack  Keeps the elements
	     * @param expression Given expression
	     * @return Returns last result of expression
	     */
	    public static Double evaluatePrefix(Stack<Double> Stack,String expression) 
	    { 
	    	if (expression.length() < 1)
		        return null ;
	    	//Base case is if the expression doesn't have more elements
	    	 int spaceIndex = expression.indexOf(" ");
	    	 if(spaceIndex == -1) {
	    		 Stack.push(Double.parseDouble(expression));
	    		 return null;
	    	 }
	    		 String firstWord = expression.substring(0, spaceIndex);
	 	         evaluatePrefix(Stack,expression.substring(spaceIndex + 1)) ; 
	        //Recursion call
		    
	        //Check the element that if is operand push to the stack.
			    if (!(isOperator(firstWord.charAt(0)))) {
			    	double number=Double.parseDouble(firstWord); 
	                Stack.push(number);  
			    }
			    else { 
			  	  
	               //If the element is not operand than pop two element and process with incoming operator
	                double o1 = Stack.peek(); 
	                Stack.pop(); 
	                double o2 = Stack.peek(); 
	                Stack.pop(); 
	  
	                switch (expression.charAt(0)) { 
	                case '+': 
	                    Stack.push(o1 + o2); 
	                    break; 
	                case '-': 
	                    Stack.push(o1 - o2); 
	                    break; 
	                case '*': 
	                    Stack.push(o1 * o2); 
	                    break; 
	                case '/': 
	                    Stack.push(o1 / o2); 
	                    break; 
	                } 
	            } 
	  	  
	        return Stack.peek(); 
	    } 
	  
	    /**
	     * @param args String arguments
	     */
	    public static void main(String[] args) 
	    { 
	        String exprsn = "* / 6 4 + 9 8"; 
	        Stack<Double> Stack = new Stack<Double>(); 
	        System.out.println("The prefix value is : " + evaluatePrefix(Stack,exprsn)); 
	    } 
}