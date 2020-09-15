import java.util.*;
/**
 * @author Emirhan Uzun / 171044019
 * This is the main test which includes add,remove,add to index methods and try catch block for exception
 *
 */


public class MainTest {

	public static void main(String[] args) {
		LinkedArrayList<Integer> mylist = new LinkedArrayList<Integer>(3);
		 System.out.println("******************* ADD TEST *******************");
	      
		 	try{	
	        mylist.add(9);
	        mylist.add(1);
	        mylist.add(2);
	        mylist.add(4);
	        mylist.add(7);
	        mylist.add(99);
	        mylist.add(58);
	        mylist.addIndex(3,1);
	        mylist.addIndex(4, 8);
	        mylist.printArrays();

			 System.out.println("***************************************************");
			 System.out.println("******************* REMOVE TEST *******************");
			 	mylist.remove(6);
		        mylist.remove(1);
		        mylist.remove(3);
		        mylist.printArrays();
		     System.out.println("***************************************************");
			 System.out.println("******************* EXHAUSTED ARRAY TEST *******************");
			 	mylist.addIndex(3,857);
		        mylist.printArrays();
		     System.out.println("***************************************************");
			 System.out.println("******************* GET METHOD TEST *******************");
			 	System.out.println(mylist.get(6) + " is the element of index 6");
			 	System.out.println(mylist.get(3) + " is the element of index 3");
			 	System.out.println(mylist.get(10) + " is the element of index 10" );



		   
		 	}
		 	catch(Exception e) {
		 		System.out.println(e);
		 	}

	}
	
	

}
