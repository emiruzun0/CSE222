import java.util.*;

/**
 * @author Emir
 * @param <T>
 *
 */
public class MyMergeSort{


	private static void merge(LinkedList<Integer> outputSequence,
			LinkedList<Integer> leftSequence, LinkedList<Integer> rightSequence) {
		int i = 0; // Index into the left input sequence.
		int j = 0; // Index into the right input sequence.
		int k = 0; // Index into the output sequence.
		// While there is data in both input sequences
		while (i < leftSequence.size() && j < rightSequence.size()) {
			// Find the smaller and
			// insert it into the output sequence.
			int a = leftSequence.get(i);
			int b = rightSequence.get(j);
			if (a <= b) {
				outputSequence.set(k, leftSequence.get(i));
				k++;
				i++;
			} else {
				outputSequence.set(k, rightSequence.get(j));
				k++;
				j++;
			}
		}
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output.
		while (i < leftSequence.size()) {
			outputSequence.set(k, leftSequence.get(i));
			k++;
			i++;
		}
		// Copy remaining input from right sequence into output.
		while (j < rightSequence.size()) {
			outputSequence.set(k, rightSequence.get(j));
			k++;
			j++;
		}
	}

	public static void sort(LinkedList<Integer> list) {
		// A list with one element is sorted already.
		if (list.size()> 1) {
			// Split list into halves.
			int halfSize = list.size() / 2;
			//LinkedList<T> rightlist =  new Comparable[list.length - halfSize];
			// Sort the halves.
			LinkedList<Integer> leftlist = new LinkedList<>(list.subList(0, halfSize));
			LinkedList<Integer> rightlist = new LinkedList<>(list.subList(halfSize, list.size() ));
			sort(leftlist);
			sort(rightlist);
			// Merge the halves.
			merge(list, leftlist, rightlist);
		}
	}

	public static void main(String[] args) {

			
		Random rand = new Random();
		//Integer[] arr = new Integer[] {5, 2, 13, 9, 1, 7, 6, 8, 1, 15, 4, 11};
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<40000;++i) {
			list.add(rand.nextInt(10000));
		}
		//System.out.println(list.toString());
		long startTime = System.currentTimeMillis();
		sort(list);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;
		System.out.println("\n\nThe time is " + timeElapsed + " milisecond(s) for MERGE SORT WITH LINKED LIST");
			
	}
}



