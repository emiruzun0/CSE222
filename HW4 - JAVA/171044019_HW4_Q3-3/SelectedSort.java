/**
 * This class sorts the given array increasing order
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class SelectedSort {
	
	/**
	 * Finds the index of smallest element of array
	 * @param sortingList Array
	 * @param start Start index of array
	 * @param finish Finish index of array 
	 * @return Returns index of smallest element of array
	 */
	public static int minIndex(int sortingList[], int start, int finish)
    {
        if (start == finish)
            return start;

        // Find minimum of remaining elements
        int k = minIndex(sortingList, start + 1, finish);

        // Return minimum of current and remaining.
        if(sortingList[start] < sortingList[k] )	return start;
        else return k;
    }
	
	 /**
	  * Sorts the array increasing order. It runs recursively
	 * @param sortingList Array that sorting 
	 * @param start Start index of array
	 * @param finish End index of array
	 */
	public static void selectedSort(int[] sortingList, int start, int finish) {
		 	if (start >= finish)	return;
		 	else{        	        		
	 			int k = minIndex(sortingList, start, finish); 
	 			if (k != start){ 
	 	           // swap 
	 	           int temp = sortingList[k]; 
	 	           sortingList[k] = sortingList[start]; 
	 	           sortingList[start] = temp; 
	 	        } 
              

               // Sort the remaining list
               selectedSort(sortingList, start + 1, finish);

	        }
	 }
	 
	 /**
	 * @param args String arguments
	 */
	public static void main(String [] args){
	        int[] sortingList = {9,5,3,7,4,8,6};
	        
	        
	        System.out.printf("This is our initially array : ");
	        for (int i=0; i<sortingList.length; i++) {
	               System.out.printf("%d ",sortingList[i]);
	        }
	        
	        
	        selectedSort(sortingList,0,sortingList.length -1);
	       
	        System.out.printf("\n\nThe sorting list is : ");
	        for (int i=0; i<sortingList.length; i++) {
	               System.out.printf("%d ",sortingList[i]);
	        }
	}

}
