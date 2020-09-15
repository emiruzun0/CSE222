/**
 * This is test main class
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 */
public class Main {

	/**
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

		ageTree.add(new AgeData(10));
		ageTree.add(new AgeData(20));
		ageTree.add(new AgeData(5));
		ageTree.add(new AgeData(15));
		ageTree.add(new AgeData(10));
		//ageTree.remove(new AgeData(10));


		String treeStr = ageTree.toString();
		System.out.println(treeStr);
		
		System.out.println("The node that age is 10 : " + ageTree.find(new AgeData(10)).toString());
		System.out.println("It is the number of younger than 15 : " + ageTree.youngerThan(15));
		System.out.println("It is the number of older than 10 : " + ageTree.olderThan(10));


		


	}

}



