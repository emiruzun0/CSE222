import java.util.*;

/**
 * This class is to handle a file system hierarchy in a general tree structure.
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 */
public class FileSystemTree  {

		/**
		 * This inner class holds the nodes which are directories and files in it
		 * @author Emirhan Uzun
		 * @since 04/27/2019
		 */
		protected static class myNode {
			
			/**
			 * File or directory's name 
			 */
			protected String data;
			/**
			 * Holds the directory nodes
			 */
			public List<myNode> directories;
			/**
			 * Holds the file nodes
			 */
			public List<myNode> files;
			
			/**
			 * Constructor sets the filename to data and creates a file and directory list.
			 * @param filename Given name
			 */
			public myNode(String filename) {
				directories = new ArrayList<myNode>() ;
				files = new ArrayList<myNode>();
				this.data = filename;
			}
			
			/**
			 * @return the data's name 
			 */
			public String getData()
			  {
			     return this.data;
			  }

			/**
			 * Gets the node that is in index
			 * @param depth index of list
			 * @return the node which is in given directory list index
			 */
			public myNode getDirectories(int depth) {
				return directories.get(depth);
			}
			
			/**
			 * Gets the node that is in index
			 * @param depth index of list
			 * @return the node which is in given file list index
			 */
			public myNode getFiles(int depth) {
				return files.get(depth);
			}

		}

	/**
	 * The data field holds the node's 
	 */
	protected myNode root;
		
	/**
	 * This constructor sets the name to the root
	 * @param filename Given name to root node
	 */
	protected FileSystemTree(String filename) {
		root = new myNode(filename);
	}
	
	/**
	 * Splits the given string from "/" and then sends the addDirectory method 
	 * @param str Given path
	 * @throws Exception If the directory is not added, it throws the exception
	 */
	public void addDir(String str) throws Exception {
		  String[] list = str.split("/");
		  if(list[0].equals(root.getData()))  addDirectory(root.directories,list,1,list.length-1);
		  else throw new Exception("The root name is not found ! ");
	}
	
	/**
	 * This method works recursively and if the root's name matches the indexth element of the list, it calls that root
	 * @param local Given directory list 
	 * @param list Given path string list
	 * @param i It starts from and goes to the until path string list's size
	 * @param index The given path string list's size
	 * @throws Exception If the directory is not added, throws the Exception
	 */
	private void addDirectory(List<myNode> local , String[] list,int i, int index) throws Exception {
		boolean flag = false;
		if(i == index) {
			for(int j = 0;j< local.size();++j) {
				if(list[i].equals(local.get(j).getData())) flag = true;
			}
			if(!flag) {
				System.out.println("The directory '" + list[i] + "' was added ! ");
				local.add(new myNode(list[i]));
			}
			else 	System.out.println("The director is already exist ! " + list[i]);
		}
		else if(i < index) {
			for(int j = 0;j<local.size();++j) {
				if(list[i].equals(local.get(j).getData())) {
					addDirectory(local.get(j).directories,list,i+1,index);
					flag = true;
					break;
				}
			}
			if(!flag ) throw new Exception("The directory was not added ! ");
		}
	}
	

	/**
	 * Splits the given string from "/" and then sends the addToFile method 
	 * @param str Given path
	 * @throws Exception If the file is not added, it throws the exception
	 */
	public void addFile(String str) throws Exception {
		 String[] list = str.split("/");
		 if(list.length > 2)  addToFile(root.directories,list,1,list.length-1);
		 else {
			 if(list[0].equals(root.getData())) addToFile(root.files,list,1,list.length-1);
			 else throw new Exception("The root is not found ! ");
		 }
	}

	/**
	 * This method works recursively and if the root's name matches the indexth element of the list, it calls that root
	 * @param local Given directory list 
	 * @param list Given path string list
	 * @param i It starts from and goes to the until path string list's size
	 * @param index The given path string list's size
	 * @throws Exception If the file is not added, throws the Exception
	 */
	private void addToFile(List<myNode> local , String[] list,int i, int index) throws Exception {
		boolean flag = false;
		if(i == index) {
			for(int j = 0;j< local.size();++j) {
				if(list[i].equals(local.get(j).getData())) flag = true;
			}
			if(!flag) {
				System.out.println("The file '" + list[i] + "' was added ! ");
				local.add(new myNode(list[i]));
			}
			else 	System.out.println("The file is already exist ! " + list[i]);
		}
		else if(i < index) {
			for(int j = 0;j<local.size();++j) {
				if(list[i].equals(local.get(j).getData())) {
					if(i + 1 == index ) addToFile(local.get(j).files,list,i+1,index);
					else addToFile(local.get(j).directories,list,i+1,index);
					flag = true;
					break;
				}
			}
			if(!flag ) throw new Exception("The file was not added ! ");
		}
	}
	
	
	/**
	 * Splits the given string from "/" and then sends the removeFromSystem method 
	 * @param str Given path to remove
	 * @throws Exception If the node is not removed, throws the Exception
	 */
	public void remove(String str) throws Exception {
		 String[] list = str.split("/");
		 if(list.length > 2)  removeFromSystem(root,list,1,list.length-1);
		 else {
			 if(list.length == 1 && list[0].equals(root.getData()))  throw new Exception("You can not remove the root ! ");
			 else if(list[0].equals(root.getData())) removeFromSystem(root,list,1,list.length-1);
			 else throw new Exception("This node (directory or file) was not removed ! ");
		 }
	}

	/**
	 * It works recursively.In base case, if indexes are equal then check the node's name.If it matches, it will remove the node.
	 * @param root The root object
	 * @param list Given path string list
	 * @param i It starts from and goes to the until path string list's size
	 * @param index The given path string list's size
	 * @throws Exception If the node was not removed , throws the Exception
	 */
	private void removeFromSystem(myNode root, String[] list, int i, int index) throws Exception {
		int flag = -1;
		if(i == index) {
			for(int j = 0;j< root.files.size();++j) {
				if(list[i].equals(root.getFiles(j).getData())) flag = j;
			}
			if(flag != -1) {
				System.out.println("The file '" + list[i] + "' was removed from system ! ");
				root.files.remove(flag);
				return;
			}
			for(int j = 0; j< root.directories.size();++j) {
				if(list[i].equals(root.getDirectories(j).getData())) flag = j;
			}
			if(flag != -1) {
				System.out.println("The directory '" + list[i] + "' was removed from system ! ");
				root.directories.remove(flag);
				return;
			}	
			else 	System.out.println("The object( file or directory ) was not found ! " + list[i]);
		}
		else if(i < index) {
			for(int j = 0; j< root.directories.size();++j) {
				if(list[i].equals(root.getDirectories(j).getData())) {
					flag = j;
					removeFromSystem(root.getDirectories(j),list,i+1,index);
					break;
				}
			}
			if(flag == -1 ) throw new Exception("The file was not added ! ");
		}
	}

	/**
	 * It creates a string and sends the parameters to the printPath method
	 * @param str Given string to search it
	 */
	public void search(String str) {
		String sb = new String();
		printPath(sb,root,str,0);	
	}
	
	

    /**
     * This method works recursively.If the directory or file contains the string, then print the path until comes to the that root.
     * @param sb Holds the names until comes root's name which matches the searching string
     * @param root Given myNode object
     * @param str Searching string
     * @param type The node type (File or directory)
     */
    public void printPath(String sb,myNode root, String str,int type)  {  
    	
    	if(root.getData().contains(str)) {
    		if(type == 0) {
    			System.out.println("dir - " + sb.toString() + root.getData());
    		}
    		else System.out.println("file - " + sb.toString() + root.getData());
      	}
	        
    	for(int i =0;i<root.directories.size();++i) 
       		printPath(sb+root.getData()+"/",root.getDirectories(i), str,0)  ;
	    
    	for(int i =0;i<root.files.size();++i) 
	        printPath(sb+root.getData()+"/",root.getFiles(i), str,1);
     }
    
    
    
    /**
     * It creates a string to print and then send the parameters to the print method
     */
    public  void printFileSystem() {
    		String sb = new String();
    		System.out.println("\nThe File System Tree is below : \n");
		  	print(root,0,sb);
		  	System.out.println(sb.toString());
	}
    
    /**
     * It prints the node's name recursively and preorder traversal.That means first it prints the root's name and then prints directory and file in order
     * @param root Given myNode object
     * @param type The myNode type (File or directory)
     * @param sb Holds the root's names until prints the directory or file
     */
    public void print(myNode root,int type,String sb) {
    	if(type == 0) System.out.println("dir - " + sb.toString() + root.getData());
    	else System.out.println("file - " + sb.toString() + root.getData());
	  	if (!(root.files.isEmpty() && root.directories.isEmpty())) {
	      for(int i =0;i<root.directories.size();++i) {
	    	  print(root.getDirectories(i),0,sb+root.getData()+"/");
	      }
		    for(int j = 0;j<root.files.size();++j) {
		    	print(root.getFiles(j),1,sb+root.getData()+"/");
		    }
	  	}
    }
}

























