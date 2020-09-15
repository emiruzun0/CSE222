/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 * This class is the main class of this program.It ıncludes admin and arrays of customers,cargoes,branches.
 */
public class Company {
	protected static Customer customers[] ;
	protected static Cargo cargoes[] ;
	protected static Branch[] branches;
	protected Admin admin ;
	protected String companyName;
	
	/**
	 * This is the constructor.It allocate for customers and cargoes.
	 */
	public Company() {
		customers = new Customer[0];
		cargoes = new Cargo[0];
	}
	
}