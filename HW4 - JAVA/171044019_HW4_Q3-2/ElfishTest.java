/**
 * This class checks the words with recursively that is elfish word or not 
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class ElfishTest {
	
	/**
	 * This method controls the given string.If it finds the elfish letters it throws that letter from string
	 * and search the other elfish letters until end of letters 
	 * @param word Checked word
	 * @param elfishLetters Contains elfish letters (e,l,f)
	 * @param elfishLetterCount Holds number that how many elfish letters does the word have 
	 * @return Returns the elfish letters number. If it is equal to 3 (for e,l,f) this is the elfish word
	 */
	public static int ElfishTest(String word, String elfishLetters, int elfishLetterCount) {

		//Base case : If the elfish letters length is less than 1, then return.
	    if(elfishLetters.length() < 1) {
	        return 0;
	    }

	    //Checks the string contains the elfish letters.
	    if(word.contains(elfishLetters.substring(0, 1))) {
	    	elfishLetterCount = 1;
	    }
	    else {
	    	return 0;
	    }
	    
	    //Calls the recursion with counter.
	    return elfishLetterCount + ElfishTest(word, elfishLetters.substring(1, elfishLetters.length()), 0);
	}

	/**
	 * @param args String arguments
	 */
	public static void main(String args[]) {
		
		String word = "whiteleaf";
	        
	    //String word = "tasteful";
	    //String word = "unfriendly";
		//String word = "waffle";

	    String elfishLetters = "elf"; 

	    int elfishLetterCount = ElfishTest(word, elfishLetters, 0);

	    if(elfishLetters.length()== elfishLetterCount) {
	        System.out.println(word + " has  'e', 'l' and 'f' letters.\n"
	        		+ "So this is elifsh!");
	    }else{
	    	System.out.println(word + " doesn't have at least one of that 'e','l'and 'f' letters.\n"
	    			+ " So this is not elifsh!");
	    }
	}
}