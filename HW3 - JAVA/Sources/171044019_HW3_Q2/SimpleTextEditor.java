import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * This is the Simple Test Editor class which is implemented by Linked List or Array List.
 * @author Emirhan Uzun / 171044019
 * @since 03/31/2020
 *
 */
public class SimpleTextEditor {
	private List<Character> sample ;
	
	
	/**
	 * This constructor initializes the list type.
	 * @param choice This choice determines the List type
	 * @throws Exception Throws exception if the choice is not in interval(1 or 2)
	 */
	public SimpleTextEditor(int choice) throws Exception {
		if(choice == 1) sample = new ArrayList<>();
		else if(choice == 2) 	sample = new LinkedList<>();
		else throw new Exception("The choice is wrong ! ");
	}

	/**
	 * This method read the file with basic loop structure
	 * @param filename The name of the file which is read
	 * @throws IOException	It throws the exception if the file is not opened.
	 */
	public void readWithLoop(String filename) throws IOException {
		File f=new File(filename);     //Creation of File Descriptor for input file
	      FileReader fr=new FileReader(f);   //Creation of File Reader object
	      BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
	      char c ;
	      for(int i=0 ; i< f.length() ; ++i) {
	    	  c = (char) br.read();
	    	  sample.add((char)c);
	      }
	      br.close();	
	}
	
	/**
	 * This method read the file with iterator
	 * @param filename The name of the file which is read
	 * @throws IOException	It throws the exception if the file is not opened.
	 */
	public void readWithIterator(String filename) throws IOException{
		File f = new File(filename);
		FileReader fr=new FileReader(f);   //Creation of File Reader object
	    BufferedReader br=new BufferedReader(fr);
	    char c;
	    ListIterator<Character> iterator = sample.listIterator(); 
	    for(int i=0 ; i< f.length() ; ++i) {
	    	  c = (char) br.read();
	    	  iterator.add((char)c);
	    }
	    br.close();
	}
	
	
	/**
	 * This method add the string to the list with using loop
	 * @param string This string adds to the Linked List.
	 * @param index Index is specified at a position which the string is added from there
	 */
	public void addWithLoop(String string, int index) {
		for(int i=0;i< string.length();++i) {
			sample.add(index + i,(char) string.charAt(i));
		}
	}
	
	
	/**
	  * This method adds the string to the list with using iterator
	 * @param string This string adds to the Linked List.
	 * @param index Index is specified at a position which the string is added from there
	 * @throws IOException This method throws the exception if iterator doesn^t exist in this index.  
	 */
	public void addWithIterator(String string, int index) throws Exception{
		ListIterator<Character> iterator = sample.listIterator(index); 
		/*while(index > 0 && iterator.hasNext()) {
			iterator.next();
			index--;
		}*/
		for(int i = 0; i< string.length() ; ++i) {
			iterator.add((char) string.charAt(i));
		}
	}
	
	
	
	/**
	 * This method finds the string from the list with using loop
	 * @param string The search string
	 * @return Returns the start index of string if it found
	 * @throws Exception Throws exception if string was not found in list
	 */
	public int findWithLoop(String string)  throws Exception  {
		int flag = -1;
		int j = 0;
		for(int i = 0; i< sample.size() ; ++i) {
			j = 0;
			while(j < string.length()) {
				if(sample.get(i) == string.charAt(j)) {
					j++;
					i++;
				}
				else break;
			}
			if(j == string.length()) {
				flag = i-j;
				break;
			}
		}
		
		if(flag != -1) return flag ;
		else throw new Exception(string + " was not found ! ");
	}
	
	/**
	 * This method finds the string from the list with using iterator
	 * @param string The search string
	 * @return Returns the start index of string if it found
	 * @throws Exception Throws exception if string was not found in list
	 */
	public int findWithIterator(String string) throws Exception{
		int flag = -1;
		int j ;
		ListIterator<Character> iterator = sample.listIterator();

		while(iterator.hasNext()) {
			j = 0;
			while(j < string.length()) {
				if(iterator.next() == (char) string.charAt(j)) {
					j++;
				}
				else break;
			}
			if(j == string.length()) {
				flag = iterator.nextIndex() - j ;
				break;
			}
		}
		
		if(flag != -1) return flag ;
		else throw new Exception(string + " was not found ! ");
		
	}
	

	
	
	/**
	 * This method replaces all occurrences of a character with another character
	 * It uses loop
	 * @param dest The character which we change
	 * @param target The character which we put in the list
	 */
	public void replaceWithLoop(char dest,char target) {
		for(int i = 0; i< sample.size(); ++i) {
			if(sample.get(i).equals(dest))	sample.set(i, target);
		}
	}

	/**
	 * This method replaces all occurrences of a character with another character
	 * It uses iterator
	 * @param dest The character which we change
	 * @param target The character which we put in the list
	 */
	public void replaceWithIterator(char dest, char target) {
		ListIterator<Character> iterator = sample.listIterator();
		while(iterator.hasNext()) {
			if(iterator.next() == dest) iterator.set(target);;
		}
	}

	/**
	 * Prints the list
	 */
	public void print() {	
		for (Character i : sample) {
		      System.out.print(i);
		    }
		System.out.println();
	}	
	  
}

