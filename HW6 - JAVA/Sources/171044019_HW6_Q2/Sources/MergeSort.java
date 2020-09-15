import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class MergeSort {

	private static <T extends Comparable<T>> void merge(int[] outputSequence,
			int[] leftSequence, int[] rightSequence) {
		int i = 0; // Index into the left input sequence.
		int j = 0; // Index into the right input sequence.
		int k = 0; // Index into the output sequence.
		// While there is data in both input sequences
		while (i < leftSequence.length && j < rightSequence.length) {
			// Find the smaller and
			// insert it into the output sequence.
			if (compareTo(leftSequence[i],rightSequence[j]) < 0) {
				outputSequence[k++] = leftSequence[i++];
			} else {
				outputSequence[k++] = rightSequence[j++];
			}
		}
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output.
		while (i < leftSequence.length) {
			outputSequence[k++] = leftSequence[i++];
		}
		// Copy remaining input from right sequence into output.
		while (j < rightSequence.length) {
			outputSequence[k++] = rightSequence[j++];
		}
	}

	public static <T extends Comparable<T>> void sort(int[] table) {
		// A table with one element is sorted already.
		if (table.length > 1) {
			// Split table into halves.
			int halfSize = table.length / 2;
			int[] leftTable =  new int[halfSize];
			int[] rightTable = 
					 new int[table.length - halfSize];
			System.arraycopy(table, 0, leftTable, 0, halfSize);
			System.arraycopy(table, halfSize, rightTable, 0,
					table.length - halfSize);
			// Sort the halves.
			sort(leftTable);
			sort(rightTable);
			// Merge the halves.
			merge(table, leftTable, rightTable);
		}
	}

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
		int[] mergeArr = new int[180000];
		for(int i =0;i<180000;++i) {
			mergeArr[i] = rand.nextInt(100000);
		}
		long startTime = System.currentTimeMillis();
		sort(mergeArr);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;

		
		System.out.println(timeElapsed);
	}


}
