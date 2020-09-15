import java.util.*;

/**
 * @author Emir
 *
 */
public class SelectionSort {

	public static <T extends Comparable<T>> void sort(int[] selectionArr) {
		int n = selectionArr.length;
		for (int fill = 0; fill < n - 1; fill++) {
			// Invariant: table[0 . . . fill - 1] is sorted.
			int posMin = fill;
			for (int next = fill + 1; next < n; next++) {
				// Invariant: table[posMin] is the smallest item in
				// table[fill . . . next - 1].
				if ((compareTo(selectionArr[next],selectionArr[posMin])) < 0) {
					posMin = next;
				}
			}
			// assert: table[posMin] is the smallest item in
			// table[fill . . . n - 1].
			// Exchange table[fill] and table[posMin].
			int temp = selectionArr[fill];
			selectionArr[fill] = selectionArr[posMin];
			selectionArr[posMin] = temp;
			// assert: table[fill] is the smallest item in
			// table[fill . . . n - 1].
		}
		// assert: table[0 . . . n - 1] is sorted.
	}
	
	static void printArray(int[] arr) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 
	
	public static int compareTo(int pivot,int arr) {
		if (pivot < arr )	return -1;
		else if (pivot < arr) return 0;
		return 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int[] selectionArr = new int[180000];
		for(int i =0;i<180000;++i) {
			selectionArr[i] = rand.nextInt();
		}
		long startTime = System.currentTimeMillis();
		sort(selectionArr);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;
		
		System.out.println((double)timeElapsed);
	}

}
