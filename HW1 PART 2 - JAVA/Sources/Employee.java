/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This abstract class extends by Branch class.
 *
 */
public abstract class Employee extends Branch{
	public void setStatus(String trackingNumber, String currentStatus) {
		System.out.println("You can not set the status !  ");
	}
}
