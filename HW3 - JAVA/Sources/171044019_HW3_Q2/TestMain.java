import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

        
/**
 * This is the test main class for 4 different cases. It includes ArrayList,LinkedList, iterator and loop 
 * @author Emirhan Uzun / 171044019
 * @since 03/31/2020
 *
 */
public class TestMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;
		try {
			fh = new FileHandler("MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			
			Instant start = Instant.now();
			System.out.println("***************ARRAY LIST TEST WITH ITERATOR**************"); 
			SimpleTextEditor mylist = new SimpleTextEditor(1); 
			
			
			System.out.println("---Read Test ---"); 
				mylist.readWithIterator("File.txt");
				System.out.println("The file was readed with iterator. Content is : ");
				mylist.print();
				
				
			System.out.println("\n---Add Test ---"); 
				mylist.addWithIterator("Gebze", 4);
				System.out.println("This is the new version of list of characters : ");
				mylist.print();
				
			
			System.out.println("\n---Find Test ---"); 
				int index = mylist.findWithIterator("zeh");
					if(index != -1) System.out.println("The start index of searched group of character (zeh) is " + index);
					else System.out.println("The string (zeh) was not found ! ");
				mylist.print();


			System.out.println("\n---Replace Test ---"); 
				mylist.replaceWithIterator('e','J');
				System.out.println(" 'e' letters changed with 'J' letters.\n This is the last version of list of characters : ");
				mylist.print();		
				
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			logger.info("\n\nThe time is " + timeElapsed.toMillis() + " milisecond(s) for ARRAY LIST ITERATOR");
				
				
				
				//---------------------------------------------------------------
				
			Instant start2 = Instant.now();
			
			System.out.println("\n\n***************ARRAY LIST TEST WITH LOOP**************"); 
			
			SimpleTextEditor mylist2 = new SimpleTextEditor(1); 

			
			System.out.println("\n---Read Test ---"); 
				mylist2.readWithLoop("File.txt");
				System.out.println("The file was readed with iterator. Content is : ");
				mylist2.print();
					
					
			System.out.println("\n---Add Test ---"); 
				mylist2.addWithLoop("Gebze", 4);
				System.out.println("This is the new version of list of characters : ");
				mylist2.print();
					
			System.out.println("\n---Find Test ---"); 
				  index = mylist2.findWithLoop("zeh");
					if(index != -1) System.out.println("The start index of searched group of character (zeh) is " + index);
					else System.out.println("The string (zeh) was not found ! ");
				mylist2.print();

						
			System.out.println("\n---Replace Test ---"); 
				mylist2.replaceWithLoop('e','J');
				System.out.println(" 'e' letters changed with 'J' letters.\n This is the last version of list of characters : ");
				mylist2.print();
			
			Instant end2 = Instant.now();
			Duration timeElapsed2 = Duration.between(start2, end2);
			
			logger.info("\n\nThe time is " + timeElapsed2.toMillis() + " milisecond(s) for ARRAY LIST LOOP");
				
				//----------------------------------------------------------------------
					
			Instant start3 = Instant.now();
			System.out.println("\n\n***************LINKED LIST TEST WITH ITERATOR**************"); 
			SimpleTextEditor mylist3 = new SimpleTextEditor(2); 
			
			
			System.out.println("---Read Test ---"); 
			mylist3.readWithIterator("File.txt");
				System.out.println("The file was readed with iterator. Content is : ");
				mylist3.print();
				
				
			System.out.println("\n---Add Test ---"); 
			mylist3.addWithIterator("Gebze", 4);
				System.out.println("This is the new version of list of characters : ");
				mylist3.print();
				
			
			System.out.println("\n---Find Test ---"); 
				 index = mylist3.findWithIterator("zeh");
					if(index != -1) System.out.println("The start index of searched group of character (zeh) is " + index);
					else System.out.println("The string (zeh) was not found ! ");
					mylist3.print();


			System.out.println("\n---Replace Test ---"); 
				mylist3.replaceWithIterator('e','J');
				System.out.println(" 'e' letters changed with 'J' letters.\n This is the last version of list of characters : ");
			mylist3.print();
			
			Instant end3 = Instant.now();
			Duration timeElapsed3  = Duration.between(start3, end3);
			
			logger.info("The time is " + timeElapsed3.toMillis() + " milisecond(s) for LINKED LIST ITERATOR");
			
				
				//-------------------------------------------------------------------
				
				
			Instant start4 = Instant.now();
			System.out.println("\n\n***************LINKED LIST TEST WITH LOOP**************"); 
			SimpleTextEditor mylist4 = new SimpleTextEditor(2); 
			System.out.println("\n---Read Test ---"); 
			mylist4.readWithLoop("File.txt");
				System.out.println("The file was readed with iterator. Content is : ");
				mylist4.print();
				
				
			System.out.println("\n---Add Test ---"); 
			mylist4.addWithLoop("Gebze", 4);
				System.out.println("This is the new version of list of characters : ");
				mylist4.print();
				
			System.out.println("\n---Find Test ---"); 
				  index = mylist4.findWithLoop("zeh");
					if(index != -1) System.out.println("The start index of searched group of character (zeh) is " + index);
					else System.out.println("The string (zeh) was not found ! ");
					mylist4.print();

					
			System.out.println("\n---Replace Test ---"); 
			mylist4.replaceWithLoop('e','J');
			System.out.println("This is the last version of list of characters : ");
			mylist4.print();
			
			Instant end4 = Instant.now();
			Duration timeElapsed4  = Duration.between(start4, end4);
			
			logger.info("The time is " + timeElapsed4.toMillis() + " milisecond(s) for LINKED LIST LOOP");
				
		}catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch(Exception e) {
			System.out.println(e);
		}

		

	}

}
