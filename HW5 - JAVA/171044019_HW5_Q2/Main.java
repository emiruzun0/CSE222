/**
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 *
 */
public class Main {

	/**
	 * All methods (Constructors, evaluate and print methods) tested in that class 
	 * @param args String arguments 
	 */
	public static void main(String[] args) {
		ExpressionTree<String> expTree = new ExpressionTree<String>("+ + 10 * 5 15 20");
		int result1 = expTree.eval();
		System.out.println("Result is : " + result1);
		ExpressionTree<String> expTree2 = new ExpressionTree<String>("10 5 15 * + 20 +");
		int result2 = expTree2.eval();
		System.out.println("Result is : " + result2);
		

	}
}
