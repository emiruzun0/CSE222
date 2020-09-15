/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class extends from employee class and implements User interface.It includes branch employee names,surnames and id's.
 *
 */
public class BranchEmployee extends Employee implements User{
	protected String name;
	protected String surname;
	protected String employeeId;

	/**
	 * @param employeeName This is the branch employee name
	 * @param employeeSurname This is the branch employee surname
	 * @param employeeId This is the branch employee id
	 * This constructor initialize the fields.
	 */
	public BranchEmployee(String employeeName,String employeeSurname,String employeeId) {
		this.name = employeeName;
		this.surname = employeeSurname;
		this.employeeId = employeeId;
	}
	
	/**
	 * This method adds the cargo to cargo arraylists where we keep in company class
	 * @param sendername This is the cargo's sender name
	 * @param sendersurname This is the cargo's sender surname 
	 * @param receivername This is the cargo's receiver name 
	 * @param receiversurname This is the cargo's receiver surname
	 * @param trackingNumber This is the cargo's tracking number
	 */
	public void addCargo(String sendername,String sendersurname,String receivername,String receiversurname,String trackingNumber) {
		cargoes.add(new Cargo(sendername,sendersurname,receivername,receiversurname,trackingNumber));
		System.out.println(trackingNumber + " tracking number was inserted cargo array ! ");
		System.out.println(cargoes.toString());
	}
	
	/**
	 * This method removes the cargo which matches with tracking number
	 * @param trackingNumber This is the cargo's tracking number
	 * @throws Exception If the method can't find tracking number, it throws exception
	 */
	public void removeCargo(String trackingNumber) throws Exception {
		int i;
		boolean flag = false;
		for(i=0;i<cargoes.size();++i) {
			if(trackingNumber.equals(cargoes.get(i).getTrackingNumber())) {
				flag = true;
				cargoes.remove(i);
				System.out.println(trackingNumber + " tracking number was erased from cargoes ! ");
			}
		}
		if(!flag) throw new Exception(trackingNumber + " tracking number was not found ! ");
	}


	/**
	 * It sets the branch employee name (This method implements from User interface)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * It gets the branch employee name (This method implements from User interface)
	 */
	@Override
	public String getName() {
		return name;
	}


	/**
	 * It sets the branch employee surname (This method implements from User interface)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;		
	}


	/**
	 * It gets the branch employee surname (This method implements from User interface)
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * This method adds the customer to customer array which we keep in company class
	 * @param name Customer's name
	 * @param surname Customer's surname
	 */
	public void addCustomer(String name,String surname) {
		customers.add(new Customer(name,surname));
	}
	
	/**
	 * This method removes the customer which matches with name and surname
	 * @param name This is the customer name
	 * @param surname This is the customer surname
	 * @throws Exception If the method can't find customer, it throws exception
	 */
	public void removeCustomer(String name,String surname) throws Exception {
		int i;
		boolean flag = false;
		for(i=0;i<customers.size();++i) {
			if(name.equals(customers.get(i).getName()) && surname.contentEquals(customers.get(i).getSurname())) {
				flag = true;
				customers.remove(i);
				System.out.println(name + " " + surname + "  was erased from customers ! ");
			}
		}
		if(!flag)  throw new Exception(name + " " + surname + " was not found ! ");
	}

	/**
	 * This method sets the cargo's current status
	 */
	@Override
	public void setStatus(String trackingNumber,String currentStatus) {
		try{
			int i;
			boolean flag = false;
			for(i=0; i< cargoes.size() ;++i) {
				if(trackingNumber.equals(cargoes.get(i).getTrackingNumber())) {
					flag = true;
					cargoes.get(i).setCurrentStatus(currentStatus);
					System.out.println(cargoes.get(i).toString());	
				}
			}
			if(!flag) throw new Exception("The cargo was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To string returns the branch employee name,surname and employee id 
	 */
	@Override
	public String toString() {
		return "[Name = " + name + " Surname = " + surname + " Employee Id = " + employeeId + "]\n";
	}
	

}
