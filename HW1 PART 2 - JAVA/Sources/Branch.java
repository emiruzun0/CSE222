import java.util.ArrayList;

/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class extends from company class.It includes branch employee and transportation personnel array list.
 *
 */
public class Branch extends Company{
	ArrayList<BranchEmployee> branchEmployees = new ArrayList<BranchEmployee>();
	ArrayList<TransportationPersonnel> transportationPersonnel = new ArrayList<TransportationPersonnel>();
	protected String branchName;
	
	/**
	 * This is the no parameter constructor.Actually we don't need this but even if we need, we fill in it.
	 */
	public Branch() {}
	
	/**
	 * This constructor initialize the branch name and print it on screen
	 * @param branchName This is the branch name
	 */
	public Branch(String branchName) {
		this.branchName = branchName;
		System.out.println(branchName + " was added to branches ! ");
	}
	
	/**
	 * @return This method returns the branch name
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * This method sets branch(s) name
	 * @param branchName This is the branch name which we change 
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * To string returns the branch name 
	 */
	@Override
	public String toString() {
		return "Branch(s) Name =   " + branchName + " \n "  ;
	}
	
	/*public void addTransportationPersonnel(String name,String surname) {
		transportationPersonnel.add(new TransportationPersonnel(name,surname));
	}*/
}
