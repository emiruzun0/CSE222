
/**
 * The software class keeps the information about product like name,quantity etc.
 * @author Emirhan Uzun / 171044019
 * @since 5/22/2020
 *
 */
public class Software implements Comparable<Software>{
	private String name;
	private int quantity;
	private int price;
	
	
	/**
	 * Constructor with 3 parameters
	 * @param name Product name
	 * @param quantity Product quantity
	 * @param price Product price
	 */
	protected Software(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * Constructor with 2 parameters
	 * @param name Product name
	 * @param price Product price
	 */
	protected Software(String name,int price) {
		this.name = name;
		this.quantity = 1;
		this.price = price;
		
	}
	
	/**
	 * Gets the name
	 * @return the name of product
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of product
	 * @param name New name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the quantity
	 * @return the quantity of product
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Sets the quantity of product
	 * @param quantity New quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Gets the price
	 * @return the price of product
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Sets the price of product
	 * @param price New price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Compare objects with name of them
	 */
	@Override
	public int compareTo(Software o) {
		return (this.getName().compareTo(o.getName()));
	}
	
	/**
	 * Prints the informations.
	 */
	@Override
	public String toString() {
		return "\nSoftware [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}



}
