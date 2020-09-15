/**
 * 
 */

/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 * This Branch Employee class extends by Branch.It includes branch employee informations
 *
 */
public class BranchEmployee extends Branch{

	protected String employeeName;
	protected String employeeSurname;
	protected String employeeId;

	/**
	 * @param employeeName This is the employee name
	 * @param employeeSurname This is the employee surname
	 * @param employeeId This is the employee id
	 */
	public BranchEmployee(String employeeName, String employeeSurname, String employeeId) {
		this.employeeName = employeeName;
		this.employeeSurname = employeeSurname;
		this.employeeId = employeeId;
	}
	
	/**
	 * This method adds the cargo to cargoes array in Company class
	 * @param sendername This is the employee name
	 * @param sendersurname This is the employee surname 
	 * @param receivername This is the receiver name
	 * @param receiversurname This is the receiver surname 
	 * @param trackingNumber This is the tracking number of cargo
	 */
	public void addCargo(String sendername,String sendersurname,String receivername,String receiversurname,String trackingNumber) {
		int i=0;
		if(cargoes.length == 0) {
			cargoes = new Cargo[1];
			cargoes[0] = new Cargo(sendername,sendersurname,receivername,receiversurname,trackingNumber);
		}
		else {
			Cargo[] temporaryArray = new Cargo[cargoes.length];
			for(i = 0;i<cargoes.length;++i) {
				temporaryArray[i] = cargoes[i];
			}
			int k = cargoes.length +1 ;
			cargoes = new Cargo[k];
			for(i = 0;i<cargoes.length-1;++i) {
				cargoes[i] = temporaryArray[i];
			}
			
			cargoes[i] = new Cargo(sendername,sendersurname,receivername,receiversurname,trackingNumber);
		}
		System.out.println(trackingNumber + " tracking number was inserted cargo array ! ");	
	}
	
	
	/**
	 * This method removes the cargo from cargos array.It uses tracking number for search
	 * @param trackingNumber This is the tracking number of cargo
	 */
	public void removeCargo(String trackingNumber) {
		try {
			int i,j,index;
			boolean flag = false;
			for(i=0; i< cargoes.length  && (!flag);++i) {
				if( trackingNumber.equals(cargoes[i].trackingNumber)) {
					flag = true;
					break;
				}
			}
			index = i;
			if(flag) {
				Cargo[] temporaryArray = new Cargo[cargoes.length];
				for(i = 0;i<=cargoes.length;++i) {
					temporaryArray[i] = cargoes[i];
				}
				int k = cargoes.length  ;
				cargoes = new Cargo[k];
				for(j = 0;j < index;++j) {
					cargoes[j] = temporaryArray[j];
				}
				for(j=index; j< k ; ++j) {
					cargoes[j] = temporaryArray[j+1];
				}
				//cargoes[cargoes.length-1] = null;
				System.out.println(trackingNumber + " was erased from branch array ! ");
			} 
			else throw new Exception("The cargo was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	/**
	 * This method sets the cargo status 
	 * @param trackingNumber This is the tracking number
	 * @param status This is the status which we change the cargo's status
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
	
	/**
	 * This method add customer to customers array in Company class.
	 * @param name This is the customer name
	 * @param surname This is the customer surname
	 * @param trackingNumber This is the customer cargo's tracking number.
	 */
	public void addCustomer(String name,String surname,String trackingNumber) {
		int i=0;
		if(customers.length == 0) {
			customers = new Customer[1];
			customers[0] = new Customer(name,surname,trackingNumber);
		}
		else {
			Customer[] temporaryArray = new Customer[customers.length];
			for(i = 0;i<customers.length;++i) {
				temporaryArray[i] = customers[i];
			}
			int k = customers.length +1 ;
			customers = new Customer[k];
			for(i = 0;i<customers.length-1;++i) {
				customers[i] = temporaryArray[i];
			}
			
			//customers[i-1] = new Customer(name,surname,trackingNumber);
		}
		System.out.println(name + " " + surname +  "  was inserted customer array ! ");
	}
	
	/**
	 * This method removes the customer from customer array.It uses tracking number to find it
	 * @param trackingNumber This is the tracking number which we search with
	 */
	public void removeCustomer(String trackingNumber) {
		try {
			int i,j,index;
			boolean flag = false;
			for(i=0; customers[i] != null && (!flag);++i) {
				if( trackingNumber.equals(customers[i].trackingNumber)) {
					flag = true;
					break;
				}
			}
			index = i;
			if(flag) {
				Customer[] temporaryArray = new Customer[cargoes.length];
				for(i = 0;i<customers.length-1;++i) {
					temporaryArray[i] = customers[i];
				}
				int k = customers.length - 1 ;
				customers = new Customer[k];
				for(j = 0;j < index;++j) {
					customers[j] = temporaryArray[j];
				}
				for(j=index; j< k-1 ; ++j) {
					customers[j] = temporaryArray[j+1];
				}
				customers[customers.length-1] = null;
				System.out.println(trackingNumber + " was erased from customer array ! ");
			} 
			else throw new Exception("The customer was not found ! ");
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
		return "BranchEmployee [Employee Name = " + employeeName + "\nEmployee Surname = " + employeeSurname + "\nEmployee Id = "
				+ employeeId + "]";
	}

}
