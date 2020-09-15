/**
 * 
 */

/**
 * This is the Transportation Personnel class extend by Branch.It includes employees informations
 * @author Emirhan Uzun / 171044019
 *
 */
public class TransportationPersonnel extends Branch{
	protected String employeeName;
	protected String employeeSurname;
	protected String employeeId;
	
	/**
	 * @param employeeName This is the employee name
	 * @param employeeSurname This is the employee surname
	 * @param employeeId This is the employee id
	 */
	public TransportationPersonnel(String employeeName, String employeeSurname, String employeeId) {
		this.employeeName = employeeName;
		this.employeeSurname = employeeSurname;
		this.employeeId = employeeId;
	}

	/**
	 * This method sets the current status of cargoes.
	 * @param trackingNumber This is the tracking number which we set the status
	 * @param status This is the status which we would like to change it
	 */
	public void setStatus(String trackingNumber,String status) {
		try{
			int i;
			boolean flag = false;
			for(i=0; i< cargoes.length ;++i) {
				if(trackingNumber.equals(cargoes[i].getTrackingNumber())) 	flag = true;
			}
			if(flag) {
				cargoes[i].setCurrentStatus(status);
			}
			else throw new Exception("The cargo was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "TransportationPersonnel [\nEmployee Name = " + employeeName + "\nEmployee Surname = " + employeeSurname
				+ "\nEmployee Id = " + employeeId  + "]";
	}

}
