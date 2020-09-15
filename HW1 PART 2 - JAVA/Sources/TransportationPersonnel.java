/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class extends from employee class and implements User interface.It includes transportation personnel names,surnames and id's.
 *
 */
public class TransportationPersonnel extends Employee implements User {
	protected String name;
	protected String surname;
	protected String employeeId;

	/**
	 * This constructor initialize the fields.
	 * @param employeeName This is the transportation personnel name
	 * @param employeeSurname This is the transportation personnel surname
	 * @param employeeId This is the transportation personnel id
	 */
	public TransportationPersonnel(String employeeName,String employeeSurname,String id) {
		this.name = employeeName;
		this.surname = employeeSurname;
		this.employeeId = id;
	}
	
	
	/**
	 * It sets the transportation personnel name (This method implements from User interface)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * It gets the transportation personnel name (This method implements from User interface)
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * It sets the transportation personnel surname (This method implements from User interface)
	 */
	@Override
	public void setSurname(String surname) {	
		this.surname = surname;
	}
	
	/**
	 * It gets the transportation personnel surname (This method implements from User interface)
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	
	/**
	 * It gets the transportation personnel id (This method implements from User interface)
	 */
	public String getId() {
		return employeeId;
	}

	/**
	 * It sets the transportation personnel id (This method implements from User interface)
	 */
	public void setId(String id) {
		this.employeeId = id;
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
	 * To string returns the transportation personnel name,surname and employee id 
	 */
	@Override
	public String toString() {
		return "[Name = " + name + " Surname = " + surname + " Employee Id = " + employeeId + "]";
	}
	
	
	


}
