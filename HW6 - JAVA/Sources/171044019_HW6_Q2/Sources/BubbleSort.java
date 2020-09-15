import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class BubbleSort {

	public static <T extends Comparable<T>> void sort(int[] bubbleSort) {
		int pass = 1;
		boolean exchanges = false;
		do {
			// Invariant: Elements after table.length - pass + 1
			// are in place.
			exchanges = false; // No exchanges yet.
			// Compare each pair of adjacent elements.
			for (int i = 0; i < bubbleSort.length - pass; i++) {
				if (compareTo(bubbleSort[i],bubbleSort[i + 1]) > 0) {
					// Exchange pair.
					int temp = bubbleSort[i];
					bubbleSort[i] = bubbleSort[i + 1];
					bubbleSort[i + 1] = temp;
					exchanges = true; // Set flag.
				}
			}
			pass++;
		} while (exchanges);
		// assert: Array is sorted.
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
		int[] bubbleSort = new int[100000];
		for(int i =0;i<100000;++i) {
			bubbleSort[i] = rand.nextInt();
		}
		long startTime = System.currentTimeMillis();
		sort(bubbleSort);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;
		System.out.println(timeElapsed);
	}

}
