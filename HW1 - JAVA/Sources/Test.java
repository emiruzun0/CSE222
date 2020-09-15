/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 */
public class Test {
	public static void main(String[] args) {
		Company company = new Company();
		company.admin = new Admin();
		company.admin.setName("Emirhan");
		company.admin.setSurname("UZUN");
		System.out.println("Admin name and surname is "+company.admin.getName()+ " " + company.admin.getSurname()
				+ "\n---------------------------------------------------------------");	

		System.out.println("---------------------ADD BRANCH--------------------------");
		company.admin.addBranch("Kozyatagi");
		company.admin.addBranch("Maltepe");
		company.admin.addBranch("Kartal");
		company.admin.addBranch("Kadıkoy");
		
		System.out.println("-------------------REMOVE BRANCH----------------------------");
		company.admin.removeBranch("Kartal");
		System.out.println("---------------------------------------------------------------");
		System.out.println("These are the remanining branches : ");
		System.out.println(Company.branches[0].getBranchId());
		System.out.println(Company.branches[1].getBranchId());
		System.out.println(Company.branches[2].getBranchId());
		System.out.println("-----------------------ADD EMPLOYEE--------------------------------");

		company.admin.addTransportationPersonnel("Max", "Kruse", "Kozyatagi", "GTU0001");
		company.admin.addTransportationPersonnel("Alexandro", "De Souza", "Maltepe", "GTU0002");
		company.admin.addBranchEmployee("Luiz", "Gustavo", "Maltepe", "GTU0003");
		company.admin.addBranchEmployee("Mauricio", "Isla", "Kadikoy", "GTU0004");
		System.out.println("-----------------REMOVE EMPLOYEE----------------------------");

		company.admin.removeTransportationPersonnel("GTU0001");
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("The employees are : ");
		System.out.println(Company.branches[1].transportationPersonnels[0].toString());
		System.out.println(Company.branches[1].toString());
		System.out.println("\n" + Company.branches[1].branchEmployees[0].toString());
		System.out.println(Company.branches[1].toString());


		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------ADD CARGO-----------------------------");
		Company.branches[1].branchEmployees[0].addCargo("Emir", "Uzun", "Eyup","Sehir","INT1010");
		Company.branches[1].branchEmployees[0].addCargo("Deniz", "Mehtap", "Handan","Sivas","SIS1706");
		Company.branches[1].branchEmployees[0].addCargo("Feyza", "Cendek", "Emirhan","Uzun","LOV2001");
		
		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------REMOVE CARGO-----------------------------");
		
		//Company.branches[1].branchEmployees[0].removeCargo("LOV2001");
		
		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------ADD CUSTOMER-----------------------------");
		
		Company.branches[1].branchEmployees[0].addCustomer("Emir", "Monster","INT2020");

		
		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------REMOVE CUSTOMER-----------------------------");
		
		//Company.branches[1].branchEmployees[0].removeCustomer("INT2020");

		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------BRANCH EMPLOYEE SET STATUS -----------------------------");
		
		//Company.branches[1].branchEmployees[0].setStatus("1010","Delivered");
		
		System.out.println("---------------------------------------------------------------");

		System.out.println("-----------------TRANSPORTATION EMPLOYEE SET STATUS -----------------------------");
		
		//Company.branches[1].transportationPersonnels[0].setStatus("INT2020","Delivered");

		
		System.out.println("---------------------------------------------------------------");

		System.out.println("----------------- CUSTOMER FIND CARGO-----------------------------");

		//Company.customers[0].findCargo("1010");


	}
}



