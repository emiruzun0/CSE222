
/**
 * @author Emirhan Uzun / 171044019
 * @since 03/01/2020
 * This class extends by Company class and implements User interface.It includes also admin's name and surname.
 *
 */
public class Admin extends Company implements User{
	protected String name;
	protected String surname;
	
	/**
	 * @param name This is the admin name
	 * @param surname This is the admin surname
	 */
	public Admin(String name,String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	/**
	 *	It sets the admin name (This method implements from User interface)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  It gets the admin name (This method implements from User interface)
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 *	It sets the admin surname (This method implements from User interface)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 *  It gets the admin surname (This method implements from User interface)
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	
	/**
	 * This method adds the branch to branch array in Company class
	 * @param branchName This is the branch's name
	 */
	public void addBranch(String branchName) {
		branches.add(new Branch(branchName));
	}
	
	/**
	 * This method finds the branch and removes from branch array which in Company class
	 * @param branchName It is the branch's name
	 * @throws Exception If method can't find the branch, it throws the exception
	 */
	public void removeBranch(Object branchName) throws Exception {
			int i;
			for(i=0;i<branches.size();++i) {
				if(branchName.equals(Company.branches.get(i).getBranchName())) {
					break;
				}
			}
			if(i < branches.size()) {
			branches.remove(i);
				System.out.println(branchName + " was erased from branch array ! ");
			} 
			else throw new Exception(branchName + " branch was not found ! ");
	}
	
	/**
	 * This method adds the branch employee to branch employee array which is in branch class
	 * @param name This is the branch employee's name
	 * @param surname This is the branch employee's surname
	 * @param branchName This is the branch name which is we added employee in it
	 * @param employeeId This is the branch employee's id
	 * @throws Exception If method can't find the branch, it throws the exception
	 */
	public void addBranchEmployee(String name,String surname,String branchName,String employeeId) throws Exception {
		int i;
		for(i=0;i<branches.size();++i) {
			if(branchName.equals(Company.branches.get(i).getBranchName())) {
				Company.branches.get(i).branchEmployees.add(new BranchEmployee(name,surname,employeeId));
				System.out.println(name  + surname  + " was inserted to branch employee in branch " + branchName );
				break;
			}
		}
		if(i >= branches.size()) throw new Exception(branchName + " branch was not found ! ");
		
	}
	
	/**
	 * This method removes the branch employee from branch employee array which is in branch class
	 * @param employeeName This is the employee's name
	 * @throws Exception If the method can't find the employee name or branch, it throws the exception
	 */
	public void removeBranchEmployee(String employeeName) throws Exception {
		int i,j;
		boolean flag = false;
		for(i=0;i<branches.size() ;++i) {
			for(j=0;j<branches.get(i).branchEmployees.size();++j) {
				if(employeeName.equals(Company.branches.get(i).branchEmployees.get(j).getName())) {
					branches.get(i).branchEmployees.remove(j);
					System.out.println(employeeName + " was erased from branch employee array ! ");
					flag = true;
				}
			}
		}
		if(!flag) throw new Exception(employeeName + " branch employee was not found ! ");
	}
	
	/**
	 * This method adds the transportation personnel to transportation personnel array which is in branch class
	 * @param name This is the transportation personnel's name
	 * @param surname This is the transportation personnel's surname
	 * @param branchName This is the branch name which is we added personnel in it
	 * @param employeeId This is the transportation personnel's id
	 * @throws Exception If method can't find the branch, it throws the exception
	 */
	public void addTransportationPersonnel(String name,String surname,String branchName,String employeeId) throws Exception {
		int i;
		boolean flag = false;
		for(i=0;i<branches.size();++i) {
			if(branchName.equals(Company.branches.get(i).getBranchName())) {
				Company.branches.get(i).transportationPersonnel.add(new TransportationPersonnel(name,surname,employeeId));
				System.out.println(name  + surname + " was inserted to transportation employee in branch " + branchName );
				flag = true ;
			}
		}
		if(!flag) throw new Exception(branchName + " branch was not found ! ");

	}
	
	/**
	 * This method removes transportation personnel from transportation personnel array which is in branch class
	 * @param employeeName This is the transportation personnel's name
	 * @throws Exception If the method can't find the employee name or branch, it throws the exception
	 */
	public void removeTransportationPersonnel(String employeeName) throws Exception {
		int i,j;
		boolean flag = false;
		for(i=0;i<branches.size() && (!flag);++i) {
			for(j=0;j<branches.get(i).transportationPersonnel.size();++j) {
				if(employeeName.equals(Company.branches.get(i).transportationPersonnel.get(j).getName())) {
					branches.get(i).transportationPersonnel.remove(j);
					System.out.println(employeeName + " was erased from transportation employee array ! ");
					flag = true;
				}
			}
		}
		if(!flag)  throw new Exception(employeeName + " transportation employee was not found ! ");
	}
	
	
}






















