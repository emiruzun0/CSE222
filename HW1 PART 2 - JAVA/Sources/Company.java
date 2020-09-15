import java.util.ArrayList; 

/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class super class.It includes customer,cargo and branch arraylist.And also it includes admin.
 *
 */
public class Company {
	protected static ArrayList<Customer> customers = new ArrayList<Customer>();
	protected static ArrayList<Cargo> cargoes = new ArrayList<Cargo>();
	public static ArrayList<Branch> branches = new ArrayList<Branch>();
	protected Admin admin ;
}