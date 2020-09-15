import java.util.*;
/**
 * @author Emir
 *
 */
public class MyQuickSort{
	public static void sort(LinkedList<Integer> table) {
		quickSort(table,0,table.size()-1);
	}

	private static void quickSort(LinkedList<Integer> table, int first, int last) {
		if(first < last) {
			int pivIndex = partition(table,first,last);

			quickSort(table,first,pivIndex-1);

			quickSort(table,pivIndex+1,last);
		}

	}

	public static int compareTo(int v1,int v2) {
		if (v1 < v2 )	return -1;
		else if (v1 < v2) return 0;
		return 1;
	}
	private static int partition(LinkedList<Integer> table, int first, int last) {
		int pivot = table.get(first);

		int up = first;
		int down = last;
		do {
			while((up < last) && (compareTo(pivot,table.get(up)) >= 0)){
				up++;
			}

			while(compareTo(pivot,table.get(down)) < 0) {
				down--;
			}

			if(up < down) {
				swap(table,up,down);
			}
		}while(up < down);

		swap(table,first,down);
		return down;
	}

	private static void swap(LinkedList<Integer> table, int i, int j) {
		int temp = table.set(i, table.get(j));
		table.set(j, temp);			
	}

	public static void main(String[] args) {
		Random rand = new Random();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<10000;++i) {
			list.add(rand.nextInt(10000));
		}
		//System.out.println(list.toString());
		long startTime = System.currentTimeMillis();
		sort(list);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;
		System.out.println("\n\nThe time is " + timeElapsed + " milisecond(s) for QUICK SORT WITH LINKED LIST");
	}

}
