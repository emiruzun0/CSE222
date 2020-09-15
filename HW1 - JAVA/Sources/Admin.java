/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 * This is Admin class extend by Company class.It includes admin name and admin surname
 */
public class Admin extends Company{
	protected String name;
	protected String surname;
	
	/**
	 * This is no parameter constructor for admin.It allocate branch array.
	 */
	public Admin() {
		branches = new Branch[1];
	}
	
	/**
	 * This is the parameter constructor.
	 * @param name It is admin name
	 * @param surname It is admin surname
	 */
	public Admin(String name,String surname) {
		this.name = name;
		this.surname = surname;
		branches = new Branch[1];
	}
	
	/**
	 * This method adds the branch 
	 * @param branchId This is the branch name
	 */
	public void addBranch(String branchId) {
		int i=0;
		Branch[] temporaryArray = new Branch[branches.length];
		for(i = 0;i<branches.length;++i) {
			temporaryArray[i] = branches[i];
		}
		int k = branches.length +1 ;
		branches = new Branch[k];
		for(i = 0;i<branches.length-1;++i) {
			branches[i] = temporaryArray[i];
		}
		
		branches[i-1] = new Branch(branchId);
		System.out.println(branchId + " was inserted branch array ! ");
	}
	
	/**
	 * This method removes the branch array
	 * @param branchId This is the branch name which we search with that
	 */
	public void removeBranch(String branchId) {
		try {
			int i,j,index;
			boolean flag = false;
			for(i=0; branches[i] != null && (!flag);++i) {
				if( branchId.equals(branches[i].branchId)) {
					flag = true;
					break;
				}
			}
			index = i;
			if(flag) {
				Branch[] temporaryArray = new Branch[branches.length];
				for(i = 0;i<branches.length-1;++i) {
					temporaryArray[i] = branches[i];
				}
				int k = branches.length - 1 ;
				branches = new Branch[k];
				for(j = 0;j < index;++j) {
					branches[j] = temporaryArray[j];
				}
				for(j=index; j< k-1 ; ++j) {
					branches[j] = temporaryArray[j+1];
				}
				branches[branches.length-1] = null;
				System.out.println(branchId + " was erased from branch array ! ");
			} 
			else throw new Exception("The branch was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method adds branch employees to branch employee arrays
	 * @param name This is the branch employee name
	 * @param surname This is the branch employee surname
	 * @param branchId This is the branch name
	 * @param employeeId This is the employee id 
	 */
	public void addBranchEmployee(String name,String surname,String branchId,String employeeId) {
		int i,j,k ;
		for(i= 0;i < branches.length -1;++i) {
			if(branchId.equals(branches[i].getBranchId())) {
				BranchEmployee[] temp = new BranchEmployee[branches[i].branchEmployees.length];
				for(j= 0;j<branches[i].branchEmployees.length;++j) {
					temp[j] = branches[i].branchEmployees[j];
				}
				k = branches[i].branchEmployees.length + 1;
				branches[i].branchEmployees = new BranchEmployee[k];
				for(j=0;j<branches[i].branchEmployees.length-1;++j)	branches[i].branchEmployees[j] = temp[j];
				branches[i].branchEmployees[j-1] = new BranchEmployee(name,surname,employeeId);
			}
		}
		System.out.println(name + " " + surname + " was inserted as branch employee in  " + branchId + " with " + employeeId + " number");
	}
	
	
	
	/**
	 * This method removes the branch employee from the branch employee array
	 * @param employeeId This is the branch employee id which we search with
	 */
	public void removeBranchEmployee(String employeeId) {
		int i,j = 0,k,finding_x = 0,finding_y = 0,index1 = 0,index2 = 0;
		try {
			boolean flag = false;
			for(i=0;i<  branches.length -1 && (!flag);++i) {
				for(j=0;j<branches[i].branchEmployees.length-1 && (!flag);++j) {
					if( employeeId.equals(branches[i].branchEmployees[j].getEmployeeId())) {
						finding_x = i;
						finding_y = j;
						flag = true;
						break;
					}
				}
				index1 = finding_x;
				index2 = finding_y;
			}
			if(flag) {
				BranchEmployee[] temporaryArray = new BranchEmployee[branches[index1].branchEmployees.length];
				for(i = 0;i<branches[index1].branchEmployees.length-1;++i) {
					temporaryArray[i] = branches[index1].branchEmployees[i];
				}
				k = branches[index1].branchEmployees.length - 1 ;
				branches[index1].branchEmployees = new BranchEmployee[k];
				for(j = 0;j < index2;++j) {
					branches[index1].branchEmployees[j] = temporaryArray[j];
				}
				for(j= finding_y; j< k-1 ; ++j) {
					branches[j] = temporaryArray[j+1];
				}
				branches[branches.length-1] = null;

			} 
			else throw new Exception("The branch was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method adds transportation employees to transportation employee arrays
	 * @param name This is the transportation employee name
	 * @param surname This is the transportation employee surname
	 * @param branchId This is the branch name
	 * @param employeeId This is the transportation employee id 
	 */
	public void addTransportationPersonnel(String name,String surname,String branchId,String employeeId) {
		int i ,j,k;
		for(i= 0;i < branches.length-1 ;++i) {
			if( branchId.equals(branches[i].getBranchId())) {
				TransportationPersonnel[] temp = new TransportationPersonnel[branches[i].transportationPersonnels.length];
				for(j= 0;j< branches[i].transportationPersonnels.length;++j) {
					temp[j] = branches[i].transportationPersonnels[j];
				}
				k = branches[i].transportationPersonnels.length + 1;
				branches[i].transportationPersonnels = new TransportationPersonnel[k];
				for(j=0;j<branches[i].transportationPersonnels.length-1;++j)	branches[i].transportationPersonnels[j] = temp[j];
				branches[i].transportationPersonnels[j-1] = new TransportationPersonnel(name,surname,employeeId);
			}
		}
		System.out.println(name + " " + surname + " was inserted as transportation personnel in " + branchId + " with " + employeeId + " number");

	}
	
	/**
	 * This method remove the transportation employee from transportation employee arrays
	 * @param employeeId This is the transportation employee id which we search with
	 */
	public void removeTransportationPersonnel(String employeeId) {
		int i,j = 0,k,finding_x = 0,finding_y = 0,index1 = 0,index2 = 0;
		try {
			boolean flag = false;
			for(i=0;i<  branches.length -1 && (!flag);++i) {
				for(j=0;j<branches[i].transportationPersonnels.length -1 && (!flag);++j) {
					if( employeeId.equals(branches[i].transportationPersonnels[j].getEmployeeId())) {
						finding_x = i;
						finding_y = j;
						flag = true;
						break;
					}
				}
				index1 = finding_x;
				index2 = finding_y;
			}
			if(flag) {
				System.out.println(branches[index1].transportationPersonnels[index2].getEmployeeName() + " " +
						branches[index1].transportationPersonnels[index2].getEmployeeSurname() + " was deleted as branch employee in  " + branches[index1].getBranchId() + " with " + employeeId + " number");
			
				TransportationPersonnel[] temporaryArray = new TransportationPersonnel[branches[index1].transportationPersonnels.length];
				for(i = 0;i<branches[index1].transportationPersonnels.length-1;++i) {
					temporaryArray[i] = branches[index1].transportationPersonnels[i];
				}
				k = branches[index1].transportationPersonnels.length - 1 ;
				branches[index1].transportationPersonnels = new TransportationPersonnel[k];
				for(j = 0;j < index2;++j) {
					branches[index1].transportationPersonnels[j] = temporaryArray[j];
				}
				for(j= finding_y; j< k-1 ; ++j) {
					branches[j] = temporaryArray[j+1];
				}
				branches[branches.length-1] = null;
			} 
			else throw new Exception("The branch was not found ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
