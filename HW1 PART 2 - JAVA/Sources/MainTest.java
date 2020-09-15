/**
 * @author Emirhan Uzun / 171044019
 * @since 03/01/2020
 *
 */
public class MainTest {
	public static void main(String[] args) throws Exception {
		Company company =  new Company(); 
		company.admin = new Admin("Emirhan","Uzun");
		System.out.println("Admin name and surname is "+ company.admin.getName()+ " " + company.admin.getSurname()
		+ "\n---------------------------------------------------------------");	
		
		System.out.println("---------------------ADD BRANCH--------------------------------");
		company.admin.addBranch("Kadikoy");
		company.admin.addBranch("Maltepe");
		company.admin.addBranch("Kartal");
		company.admin.addBranch("Bostanci");
		System.out.println(Company.branches.toString());
		System.out.println("---------------------------------------------------------------");
		
		
		System.out.println("-------------------REMOVE BRANCH----------------------------");
		try{
			company.admin.removeBranch("Maltepe");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Company.branches.toString());
		
		System.out.println("---------------------------------------------------------------");
		
		
		System.out.println("-----------------------ADD EMPLOYEE--------------------------------");
		try {
			company.admin.addBranchEmployee("Deniz", "Uzun", "Kadikoy","HMO0001");
			company.admin.addBranchEmployee("Feyza", "Cendek", "Bostanci", "LOV2001");
			company.admin.addBranchEmployee("Yagiz", "Efe", "Kartal", "CCK2598");
			company.admin.addBranchEmployee("Efe", "Omur", "Kartal", "CLK4735");
			company.admin.addTransportationPersonnel("Ali", "Calisir", "Kadikoy", "NEV3450");
			company.admin.addTransportationPersonnel("Ramazan", "Sari", "Bostanci", "DSL6110");
			company.admin.addTransportationPersonnel("Mustafa", "Surun", "Kartal", "LOL4988");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
			System.out.print("\n\n" + Company.branches.get(0).toString() + " Branch's employee(s) : \n");
			System.out.println(Company.branches.get(0).branchEmployees.toString());
			System.out.print(" Transportation Personnel(s) : \n");
			System.out.println(Company.branches.get(0).transportationPersonnel.toString());
			System.out.print("\n" + Company.branches.get(1).toString() + " Branch's employee(s) : \n");
			System.out.println(Company.branches.get(1).branchEmployees.toString());
			System.out.print(" Transportation Personnel(s) : \n");
			System.out.println(Company.branches.get(1).transportationPersonnel.toString());
			System.out.print("\n" + Company.branches.get(2).toString() + " Branch's employee(s) : \n");
			System.out.println(Company.branches.get(2).branchEmployees.toString());
			System.out.print(" Transportation Personnel(s) : \n");
			System.out.println(Company.branches.get(2).transportationPersonnel.toString());
		System.out.println("---------------------------------------------------------------");
		
		
		System.out.println("-----------------REMOVE EMPLOYEE----------------------------");
		try {
			company.admin.removeBranchEmployee("Yagiz");
			company.admin.removeTransportationPersonnel("Mustafa");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("---------------------ADD CARGO---------------------------------");
			Company.branches.get(2).branchEmployees.get(0).addCargo("Handan", "Uzun", "Hilal", "Okuyan", "SMK5834");
			Company.branches.get(0).branchEmployees.get(0).addCargo("Gulsen", "Cinar", "Abdullah", "Aydogan", "CRM1977");
			Company.branches.get(2).branchEmployees.get(0).addCargo("Enes", "Kartal", "Melek", "Yilmaz", "SVS1566");
			Company.branches.get(2).branchEmployees.get(0).addCargo("Cemal", "Boyraz", "Taner", "Keskin", "OMT4635");
		System.out.println("---------------------------------------------------------------");

		
		System.out.println("---------------------REMOVE CARGO---------------------------------");
			Company.branches.get(2).branchEmployees.get(0).removeCargo("SMK5834");
		System.out.println("---------------------------------------------------------------");

		
		System.out.println("---------------------ADD CUSTOMER---------------------------------");
			Company.branches.get(1).branchEmployees.get(0).addCustomer("Fatma", "Erdogan");
			Company.branches.get(1).branchEmployees.get(0).addCustomer("Sena", "Durgut");
		System.out.println("---------------------------------------------------------------");
		
		
		System.out.println("---------------------REMOVE CUSTOMER---------------------------------");
			Company.branches.get(1).branchEmployees.get(0).removeCustomer("Sena", "Durgut");
		System.out.println("---------------------------------------------------------------");
		
		
		System.out.println("-----------------BRANCH EMPLOYEE CHANGES SET STATUS -----------------------------");
			Company.branches.get(0).branchEmployees.get(0).setStatus("SVS1566", "Delivered");
		System.out.println("---------------------------------------------------------------");

		
		System.out.println("-----------------TRANSPORTATION EMPLOYEE CHANGES SET STATUS -----------------------------");
			Company.branches.get(2).transportationPersonnel.get(0).setStatus("CRM1977", "Delivered");
		System.out.println("---------------------------------------------------------------");

		
		System.out.println("----------------- CUSTOMER FIND CARGO-----------------------------");
			Company.customers.get(0).findCargo("OMT4635");
		System.out.println("---------------------------------------------------------------");

			
	}
}















