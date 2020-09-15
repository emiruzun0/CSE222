import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class InsertionSort {


	public static <T extends Comparable<T>> void sort(int[] table) {
		for (int nextPos = 1; nextPos < table.length; nextPos++) {
			// Invariant: table[0 . . . nextPos - 1] is sorted.
			// Insert element at position nextPos
			// in the sorted subarray.
			insert(table, nextPos);
		} // End for.
	} // End sort.
	/* Insert the element at nextPos where it belongs
	 * in the array.
	 * @pre table[0 . . . nextPos - 1] is sorted.
	 * @post table[0 . . . nextPos] is sorted.
	 * @param table The array being sorted
	 * @param nextPos The position of the element to insert */
	private static <T extends Comparable<T>> void insert(int[] table,
			int nextPos) {
		int nextVal = table[nextPos]; // Element to insert.
		while (nextPos > 0
				&& compareTo(nextVal,table[nextPos - 1]) < 0) {
			table[nextPos] = table[nextPos - 1]; // Shift down.
			nextPos--; // Check next smaller element.
		}
		// Insert nextVal at nextPos.
		table[nextPos] = nextVal;
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
		int[] insertionSort = new int[10000];
		for(int i =0;i<10000;++i) {
			insertionSort[i] = rand.nextInt();
		}
		long startTime = System.currentTimeMillis();
		sort(insertionSort);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;
		System.out.println(timeElapsed);

	}

}
