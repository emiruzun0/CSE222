/**
 * This is the test main class. All methods tested 
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 */
public class Main {

	/**
	 * @param args String arguments
	 * @throws Exception If methods finds an error or doesn't complete operations, then throws Exception
	 */
	public static void main(String[] args) throws Exception {
		FileSystemTree myFileSystem = new FileSystemTree("root");
		
		try{
			myFileSystem.addDir("root/first_directory");
			myFileSystem.addDir("root/second_directory");
			myFileSystem.addFile("root/first_directory/new_file.txt");
			myFileSystem.addDir("root/second_directory/new_directory");
			myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
			//myFileSystem.remove("root/second_directory/new_directory");

			System.out.println("\nThe paths that contains the 'new' string : \n");
			myFileSystem.search("new");
			
			myFileSystem.printFileSystem();
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}