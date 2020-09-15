import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class HeapSort {

	public static <T extends Comparable<T>> void sort(int[] table) {
		buildHeap(table);
		shrinkHeap(table);
	}
	/**buildHeap transforms the table into a heap.
	 * @pre The array contains at least one item.
	 * @post All items in the array are in heap order.
	 * @param table The array to be transformed into a heap
	 */
	private static <T extends Comparable<T>> void buildHeap(int[] table) {
		int n = 1;
		// Invariant: table[0 . . . n - 1] is a heap.
		while (n < table.length) {
			n++; // Add a new item to the heap and reheap.
			int child = n - 1;
			int parent = (child - 1) / 2; // Find parent.
			while (parent >= 0
					&& compareTo(table[parent],table[child]) < 0) {
				swap(table, parent, child);
				child = parent;
				parent = (child - 1) / 2;
			}
		}
	}

	private static <T extends Comparable<T>> void shrinkHeap(int[] table) {
		int n = table.length;
		// Invariant: table[0 . . . n - 1] forms a heap.
		// table[n . . . table.length - 1] is sorted.
		while (n > 0) {
			n--;
			swap(table, 0, n);
			// table[1 . . . n - 1] form a heap.
			// table[n . . . table.length - 1] is sorted.
			int parent = 0;
			while (true) {
				int leftChild = 2 * parent + 1;
				if (leftChild >= n) {
					break; // No more children.
				}
				int rightChild = leftChild + 1;
				// Find the larger of the two children.
				int maxChild = leftChild;
				if (rightChild < n // There is a right child.
						&& compareTo(table[leftChild],table[rightChild]) < 0) {
					maxChild = rightChild;
				}
				// If the parent is smaller than the larger child,
				if (compareTo(table[parent],table[maxChild]) < 0) {
					// Swap the parent and child.
					swap(table, parent, maxChild);
					// Continue at the child level.
					parent = maxChild;
				} else { // Heap property is restored.
					break; // Exit the loop.
				}
			}
		}
	}

	private static <T extends Comparable<T>> void swap(int[] table,
			int i, int j) {
		int temp = table[i];
		table[i] = table[j];
		table[j] = temp;
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
		int[] heapArr = new int[10000];
		for(int i =0;i<10000;++i) {
			heapArr[i] = rand.nextInt();
		}
		long startTime = System.currentTimeMillis();
		sort(heapArr);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;

		

		System.out.println(timeElapsed);
	}
}