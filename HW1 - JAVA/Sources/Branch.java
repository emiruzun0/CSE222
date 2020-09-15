
/**
 * This 
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 * This Branch class extend by Company class.It includes branch id,arrays of transportation personnel and branch employee
 */
public class Branch extends Company{
	protected String branchId;
	protected TransportationPersonnel[] transportationPersonnels;
	protected BranchEmployee[]	branchEmployees;
	
	/**
	 * This is the no parameter constructor of Branch class.It allocates arrays
	 */
	public Branch() {
		transportationPersonnels = new TransportationPersonnel[1];
		branchEmployees = new BranchEmployee[1];
	}
	
	/**
	 * This is the constructor for Branch class.It assigns the id.It allocates arrays
	 * @param branchId This is the branch Id 
	 */
	public Branch(String branchId) {
		this.branchId = branchId;
		transportationPersonnels = new TransportationPersonnel[1];
		branchEmployees = new BranchEmployee[1];
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Branch [Branch Name=" + branchId + "]";
	}
	
	
}
