
/**
 * 
 */

/**
 * @author Emir
 *
 */
public class QuickSort {

	public <T extends Comparable<T>> void sort(T[] table) {
		// Sort the whole table.
		quickSort(table, 0, table.length - 1);
	}
	/**
	 * Sort a part of the table using the quicksort algorithm.
	 * @post The part of table from first through last is sorted.
	 * @param table The array to be sorted
	 * @param first The index of the low bound
	 * @param last The index of the high bound
	 */
	protected <T extends Comparable<T>> void quickSort(T[] table,
			int first,
			int last) {
		if (first < last) { // There is data to be sorted.
			// Partition the table.
			int pivIndex = partition(table, first, last);
			// Sort the left half.
			quickSort(table, first, pivIndex - 1);
			// Sort the right half.
			quickSort(table, pivIndex + 1, last);
		}
	}

	protected <T extends Comparable<T>> int partition(T[] table,
			int first, int last) {
		// Select the first item as the pivot value.
		T pivot = table[first];
		int up = first; int down = last;
		do {
			// Invariant:
			// All items in table[first . . . up - 1] <= pivot
			// All items in table[down + 1 . . . last] > pivot
			while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
				up++;
			}
			// assert: up equals last or table[up] > pivot.
			while (pivot.compareTo(table[down]) < 0) {
				down--;
			}
			// assert: down equals first or table[down] <= pivot.
			if (up < down) { // if up is to the left of down.
				// Exchange table[up] and table[down].
				swap(table, up, down);
			}
		} while (up < down); // Repeat while up is left of down.
		// Exchange table[first] and table[down] thus putting the
		// pivot value where it belongs.
		swap(table, first, down);
		// Return the index of the pivot value.
		return down;
	}

	private static <T extends Comparable<T>> void swap(T[] table,
			int i, int j) {
		T temp = table[i];
		table[i] = table[j];
		table[j] = temp;
	}

}
