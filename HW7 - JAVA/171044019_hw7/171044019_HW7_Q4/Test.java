import java.util.*;
/**
 * The test main class 
 * @author Emirhan Uzun / 171044019
 * @since 05/22/2020
 * 
 */
public class Test {

	/**
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		BinarySearchTree<Software> tempTree = new BinarySearchTree<Software>();
		SoftwareStore tree = new SoftwareStore(tempTree);
		tree.add(new Software("Adobe Photoshop 6.0",1,15));
		tree.add(new Software("Adobe Photoshop 6.2",40,50));
		tree.add(new Software("Norton 4.5",60,30));
		tree.add(new Software("Norton 5.5",25,90));
		tree.add(new Software("Adobe Flash 3.3",35,80));
		tree.add(new Software("Adobe Flash 4.0.",55,20));

		System.out.println("Please enter a name for admin : ");
		String name = scan.nextLine();
		System.out.println("Plase enter a password for admin : ");
		String password = scan.nextLine();

		Admin admin = new Admin(name,password);
		tree.setAdmin(admin);


		tree.menu();


		scan.close();
	}

}
