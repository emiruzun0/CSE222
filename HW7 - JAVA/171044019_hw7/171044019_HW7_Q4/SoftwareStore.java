import java.util.*;
/**
 * The software store class 
 * @author Emirhan Uzun / 171044019
 * @since 05/22/2020
 *
 */
public class SoftwareStore  {
	/**
	 * This is the admin object for accessing private methods.
	 */
	protected Admin admin;
	/**
	 * Scanner for take input from user
	 */
	Scanner scan = new Scanner(System.in);

	SearchTree<Software> tree;


	public SoftwareStore(SearchTree<Software> tree) {
		this.tree = tree;
	}

	/**
	 * Sets the admin object 
	 * @param admin Admin object to initialize
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;	
	}

	/**
	 * Add the software to store
	 * @param item Given item for add to store
	 * @return object which is added
	 */
	public boolean add(Software item) {
		Software temp = tree.find(item);
		if(temp!= null) {
			tree.find(item).setQuantity(temp.getQuantity()+item.getQuantity());
			tree.find(item).setPrice(item.getPrice());
		}
		else {
			tree.add(item);
		}
		return true;
	}

	/**
	 * Finds the object if it is in tree or null otherwise
	 * @param item Given item to find
	 * @return object finding or null otherwise
	 */
	public Software find(Software item) {
		Software temp = tree.find(item);
		return temp;
	}

	/**
	 * Returns true if the item in tree
	 * @param target the given item to check if tree contains this
	 * @return true if the object is found
	 */
	public boolean contains(Software target) {
		return tree.contains(target);
	}

	/**
	 * Deletes the object from tree or decrease the quantity of software product
	 * @param target The given object to be delete
	 * @return object if it is deleted or null otherwise
	 */
	public Software delete(Software target) {
		Software temp = tree.find(target);
		if(tree.contains(target)) {
			if(temp.getQuantity() -  target.getQuantity() < 2) {
				tree.remove(target);
				System.out.println("Quantity is less than 1 so this product was completely removed ");
			}
			else {
				tree.find(target).setQuantity(temp.getQuantity() - target.getQuantity());
			}
		}
		else {
			System.out.println("The product was not found ! ");
		}
		return temp;
	}

	/**
	 * Remove the product from tree or decrease the quantity of software product
	 * @param target Removed object
	 * @return true if it is removed
	 */
	public boolean remove(Software target) {
		if(tree.contains(target)) {
			delete(target);
			return true;
		}
		System.out.println("This product was not found ! ");
		return false;
	}

	/**
	 * Controls the admin informations to login
	 * @param name Given Name
	 * @param password Given Password
	 * @return true if the informations are matched.
	 */
	public boolean isValid(String name, String password) {
		if(admin.name.equalsIgnoreCase(name)) {
			if(admin.password.equalsIgnoreCase(password)) return true;
			return false;
		}

		return false;
	}


	/**
	 * The library menu 
	 */
	public void menu() {
		try{
			int choice;
			boolean flag = true;

			while (flag) {
				System.out.println("--------------------LIBRARY AUTOMATION SYSTEM----------------------");
				System.out.printf("1. Search Software by Name\n2. Update (Admin Login)\n3. Show all softwares\n4. Exit");
				System.out.println("\n-------------------------------------------------------------------");
				System.out.println("Please enter choice  : ");

				choice = scan.nextInt();

				switch (choice) {
				case 1:
					searchByName();
					break;
				case 2:
					System.out.println("Please enter your name : ");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println("Please enter the your password : ");
					String password = scan.nextLine();
					if(isValid(name,password)) adminPanel();
					else{
						System.out.println("The name or password are false ! ");
					}
					break;
				case 3:
					System.out.println(tree.toString());
					break;
				case 4:
					System.out.println("Exiting..!");
					flag = false;
					break;
				default:
					System.out.println("You've choosen wrong input");
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}


	}

	/**
	 * Search the product information with product name
	 */
	private void searchByName() {
		System.out.println("Please enter product name: \n");
		scan.nextLine();
		String productName = scan.nextLine();
		Software temp = new Software(productName,0);
		if(contains(new Software(productName,0))) {
			System.out.println(tree.find(temp).toString());
		}
		else System.out.println("This product " + temp.getName() + " was not found ! ");
	}

	/**
	 * From the menu, if the user choose the admin panel then this method works
	 */
	public void adminPanel() {
		boolean flag = true;
		int choice;

		while(flag) {
			System.out.printf("1. Add Software\n2. Delete Software\n3. Update Information\n4. Exit");
			System.out.println("\n--------------------------------------------------------");
			System.out.println("\nPlease select menu : ");
			try{
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					addSoftware();
					break;
				case 2:
					deleteSoftware();
					break;
				case 3:
					updateStatus();
					break;
				case 4:
					System.out.println("Backing to main menu...");
					flag = false;
					break;
				default:
					System.out.println("Invalid choice : ");
					break;
				}
			}catch(Exception e) {
				System.out.println("This choice is not right ! The program is shutting down");
			}


		}
	}

	/**
	 * Deletes the product or decrease the quantity with use the product name and quantity
	 */
	private void deleteSoftware() {
		boolean flag = false;
		System.out.println("Please input the Software Name : ");
		scan.nextLine();
		String name = scan.nextLine();

		try{
			while(!flag) {
				System.out.println("Please input Software Quantity : ");
				int  quantity = scan.nextInt();
				Software temp = new Software(name,quantity,0);
				if(tree.find(temp) != null) {
					if(temp.getQuantity() > tree.find(temp).getQuantity()) {
						System.out.println("The software doesn't have many quantity ! Please enter new quantity (must be smaller or equal than " + tree.find(temp).getQuantity());
					}
					else{
						remove(temp);
						flag = true;
					}
				}
				else {
					System.out.println("This software was not found ! ");
					flag = true;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Adds the product to store.
	 */
	private void addSoftware() {
		System.out.println("Please input the Software Name : ");
		scan.nextLine();
		String name = scan.nextLine();
		try{
			System.out.println("Please input Software Quantity : ");
			int  quantity = scan.nextInt();
			System.out.println("Please input Software Price ");
			int price = scan.nextInt();
			add(new Software(name,quantity,price));
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * The menu for update book informations.
	 */
	private void updateStatus() {
		boolean flag = true;
		int choice;

		try{
			while(flag) {
				System.out.printf("1. Change Software Name\n2. Change Software Quantity\n3. Change Software Price\n4. Exit");
				System.out.println("\nPlease select menu : ");
				choice = scan.nextInt();

				switch (choice) {
				case 1:
					changeSoftwareName();
					break;
				case 2:
					changeSoftwareQuantitiy();
					break;
				case 3:
					changeSoftwarePrice();
					break;
				case 4:
					System.out.println("Backing to admin menu...");
					flag = false;
					break;
				default:
					System.out.println("You've entered wrong choice ! ");
					break;
				}
			}

		}catch(Exception e) {
			System.out.println(e);
		}


	}

	/**
	 * Changes the product price if the product exists
	 */
	private void changeSoftwarePrice() {
		System.out.printf("Please enter the input for software name");
		scan.nextLine();
		String oldName = scan.nextLine();
		Software temp = tree.find(new Software(oldName,0,0));
		if(temp != null) {
			try {
				System.out.printf("Please enter the input for new sofware price");
				int newPrice = scan.nextInt();
				tree.find(temp).setPrice(newPrice);
				System.out.println("This software price was changed ! ");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("This software was not found ! ");
		}

	}

	/**
	 * Changes the product quantity if the product exists
	 */
	private void changeSoftwareQuantitiy() {
		System.out.printf("Please enter the input for software name");
		scan.nextLine();
		String oldName = scan.nextLine();
		Software temp = tree.find(new Software(oldName,0,0));
		if(temp != null) {
			try {
				System.out.printf("Please enter the input for new sofware quantity");
				int newQuantity = scan.nextInt();
				tree.find(temp).setQuantity(newQuantity);
				System.out.println("This software quantity was changed ! ");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("This software was not found ! ");
		}

	}

	/**
	 * Changes the product name if the product exists
	 */
	private void changeSoftwareName() {
		System.out.printf("Please enter the input for old software name");
		scan.nextLine();
		String oldName = scan.nextLine();
		Software temp = tree.find(new Software(oldName,0,0));
		if(temp != null) {
			System.out.printf("Please enter the input for new software name");
			String newName = scan.nextLine();
			tree.remove(find(temp));
			temp.setName(newName);
			tree.add(temp);
			System.out.println("This software name was changed ! ");
		}
		else {
			System.out.println("This software was not found ! ");
		}

	}

	@Override
	public String toString() {
		return "SoftwareStore [tree=" + tree.toString() + "]";
	}


}

