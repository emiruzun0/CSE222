/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class extends by Company class and implements User interface.It includes also customer's name and surname
 *
 */
public class Customer extends Company implements User{
	protected String customerName;
	protected String customerSurname;
	
	/**
	 * This constructor initializes the informations
	 * @param customerName This is the customer name 
	 * @param customerSurname This is the customer surname 
	 */
	public Customer(String customerName, String customerSurname) {
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		System.out.println(customerName + customerSurname + " was added to customers ! ");
	}
	
	/**
	 * It sets the customer name (This method implements from User interface)
	 */
	@Override
	public void setName(String name) {
		this.customerName = name;
	}

	/**
	 * It gets the customer name (This method implements from User interface)
	 */
	@Override
	public String getName() {
		return customerName;
	}

	/**
	 * It sets the customer surname (This method implements from User interface)
	 */
	@Override
	public void setSurname(String surname) {
		this.customerSurname = surname;
	}

	/**
	 * It gets the customer surname (This method implements from User interface)
	 */
	@Override
	public String getSurname() {
		return customerSurname;
	}
	

	/**
	 * This method finds the cargo and prints the cargo's information to screen
	 * @param trackingNumber This is the cargo's tracking number
	 * @throws Exception If the method can't find the tracking number, it throws exception
	 */
	public void findCargo(String trackingNumber) throws Exception {
		try {
			int i;
			boolean flag = false;
			for(i=0; i< cargoes.size() ;++i) {
				if(trackingNumber.equals(cargoes.get(i).getTrackingNumber())) 	{
					flag = true;
					System.out.println(cargoes.get(i).toString());
				}
			}
			if(!flag)  throw new Exception("The cargo was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
