import java.util.Scanner;

/**
 * This class creates a tree for postfix and prefix expressions
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 * @param <E> Generic
 *
 */
public class ExpressionTree<E> extends BinaryTree{
		/**
		 * The flag is the type if the first character of tree is not digit, then it sets the flag 1 otherwise 2
		 */
		protected int flag;
	
		/**
		 * Construct a tree according to given expression.It creates the nodes
		 * @param expStr Given expression
		 */
		@SuppressWarnings("unchecked")
		public ExpressionTree( String expStr )  {
				if(!Character.isDigit(expStr.charAt(0))) {
					Scanner scan = new Scanner( expStr );
					setRoot(readBinaryTree(scan).getRoot());
					System.out.println(toString());
					flag = 1 ;
				}
				else {
					//expStr = Reverse(expStr);
					expStr = reverseString(expStr);
					//System.out.println(expStr);
					Scanner scan = new Scanner( expStr );
					setRoot(readBinaryTree(scan).getRoot());
					System.out.println(toString2());
					flag = 2;
				}
				
	           // readBinaryTree( new Scanner( expStr ));       
	            //if(String)
	     }
	       
		/**
		 * Returns the reverse the postfix expression string. 
		 * @param str Given string 
		 * @return string reverse type
		 */
		public static String reverseString(String str) {
		    if (str == null)
		        return "";
		    if (!str.contains(" "))
		        return str;
		    //Find the index of white space. Then split the first word from beginning to index.
		    int spaceIndex = str.indexOf(" ");
		    String firstWord = str.substring(0, spaceIndex);
		    //Calls the recursive method with first word. At last, return this string.
		    return reverseString(str.substring(spaceIndex + 1)) + " " + firstWord;
		}
		
		/**
		 * Method to read a binary tree.
		   pre: The input consist of a preorder traversal of the 
		   		binary tree.The line "null" indicates a null tree.
		 * @param scan the Scanner attached to the input file
		 * @return The binary tree
		 */
		public static BinaryTree<String>  readBinaryTree(Scanner scan){
			String data = scan.next();
			if(data.equals(null)) return null;
			if(isNumeric(data)) {
				BinaryTree<String> leftTree = null;
				BinaryTree<String> rightTree =  null;
				return new BinaryTree<String>(data,leftTree,rightTree);
				//return new BinaryTree<String>(new Node<String>(data));
			}else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data,leftTree,rightTree);

			}
		}

		/**
		 * Determine whether this data is integer or not
		 * @param data Given string data 
		 * @return ture if the data is integer
		 */
		private static boolean isNumeric(String data) {
			 try { 
			        Integer.parseInt(data); 
			        return true;
			    } catch(NumberFormatException e) { 
			        return false; 
			    } catch(NullPointerException e) {
			        return false;
			    }
		}

		/**
		 * This method sends the tree to the evaluateTree method to find the result of expression
		 * @return the evaluateTree method to find the expression's result
		 */
		public int eval() {
			return evaluateTree(getRoot(),flag);
		}

		/**
		 * @param node given node
		 * @param flag The type of expression
		 * @return the result of expression
		 */
		private int evaluateTree(Node node, int flag) {
	        if (node.getData().equals(null))
	            return 0 ;
	        
	        if (node.left == null && node.right == null) {
	        	String number = null;
	        	number = (String) node.getData();
	        	
		        return Integer.parseInt(number);

	        }

	        
	       int leftValue = evaluateTree(node.left, flag); 
	        
	        int rightValue = evaluateTree(node.right, flag); 
  
	        if (node.getData().equals("+"))  
	            return leftValue+rightValue;  
	      
	        else if (node.getData().equals("-")) 
	        	if(flag == 1)  return leftValue-rightValue; 
	        	else return rightValue-leftValue;

	      
	        else if (node.getData().equals("*"))  
	            return leftValue*rightValue;  
	      
	        else {
	        	if(flag == 1)  return leftValue/rightValue; 
	        	else return rightValue/leftValue;
	        }
		}
		

		/**
		 * Creates a string builder and then calls the recursive postOrderTraverse method
		 * @return the 
		 */
		public String toString2() {
			StringBuilder sb = new StringBuilder();
			postOrderTraverse(getRoot(),1,sb);
			return sb.toString();
		}

		/**
		 * Perform a postorder traversal
		 * @param node The local root
		 * @param depth The depth
		 * @param sb The string buffer to save the output
		 */
		protected void postOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
			
			if(node != null) {
				postOrderTraverse(node.left,depth,sb);
				postOrderTraverse(node.right,depth,sb);
				/*for(int i = 0 ; i < depth ; ++i){
					sb.append(" ");
				}*/
				sb.append(node.toString());
				sb.append(" ");
			} /*else {
				for(int i = 0 ; i < depth ; ++i){
					sb.append(" ");
				}
				sb.append("null\n");
			}*/
		}
}
