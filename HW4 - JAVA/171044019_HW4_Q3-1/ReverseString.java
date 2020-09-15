/**
 * This class reverse the string recursively.
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class ReverseString {
	
	/**
	 * This method, returns the reversing string. This uses recursion.
	 * @param str Given string to reverse
	 * @return Returns the reversed string
	 */
	public static String reverseString(String str) {
	    if (str == null)
	        return "";
	    if (!str.contains(" "))
	        return str;
	    //Find the index of white space. Then split the first word from beginning to index.
	    int spaceIndex = str.indexOf(" ");
	    String firstWord = str.substring(0, spaceIndex);
	    //Calls the recursive method with first word. At last, return this string.
	    return reverseString(str.substring(spaceIndex + 1)) + " " + firstWord;
	}

	/**
	 * @param args String args
	 */
	public static void main(String[] args) {
	    String str = "this function writes the sentence in reverse";
	    System.out.println(reverseString(str));
	}

}
