import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class ShellSort {


	public static <T extends Comparable<T>> void sort(int[] table) {
		// Gap between adjacent elements.
		int gap = table.length / 2;
		while (gap > 0) {
			for (int nextPos = gap; nextPos < table.length;
					nextPos++) {
				// Insert element at nextPos in its subarray.
				insert(table, nextPos, gap);
			} // End for.
			// Reset gap for next pass.
			if (gap == 2) {
				gap = 1;
			} else {
				gap = (int) (gap / 2.2);
			}
		} // End while.
	} // End sort.

	private static <T extends Comparable<T>> void insert(int[] table,
			int nextPos,
			int gap) {
		int nextVal = table[nextPos]; // Element to insert.
		// Shift all values > nextVal in subarray down by gap.
		while ((nextPos > gap - 1) // First element not shifted.
				&& (compareTo(nextVal,table[nextPos - gap]) < 0)) {
			table[nextPos] = table[nextPos - gap]; // Shift down.
			nextPos -= gap; // Check next position in subarray.
		}
		table[nextPos] = nextVal; // Insert nextVal.
	}
	/**
	 * @param args
	 */
	static void printArray(int[] arr) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + "\n"); 
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
		int[] shellArr = new int[10000];
		for(int i =0;i<10000;++i) {
			shellArr[i] = i;
		}
		long startTime = System.currentTimeMillis();
		sort(shellArr);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;

		System.out.println(timeElapsed);
	}
}
