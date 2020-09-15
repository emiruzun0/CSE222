/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 * This class is the extend from Company class.It includes name,surname and tracking number.
 */
public class Customer extends Company {
	protected String name;
	protected String surname;
	protected String trackingNumber;

	/**
	 * This is the constructor of Customer class.
	 * @param name This is the name of customer
	 * @param surname This is the surname of customer
	 * @param trackingNumber This is the tracking number of customer
	 */
	public Customer(String name, String surname, String trackingNumber) {
		this.name = name;
		this.surname = surname;
		this.trackingNumber = trackingNumber;
	}
	
	/**
	 * @param trackingNumber This is the number which we search for cargo.
	 */
	public void findCargo(String trackingNumber) {
		try {
			int i;
			boolean flag = false;
			for(i=0; i< cargoes.length ;++i) {
				if(trackingNumber.equals(cargoes[i].getTrackingNumber())) 	flag = true;
			}
			if(flag) {
				System.out.println(cargoes[i].toString());
			} 
			else throw new Exception("The cargo was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
