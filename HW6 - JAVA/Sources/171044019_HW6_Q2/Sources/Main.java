import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		Integer[] quickArr = new Integer[180000];
		QuickSort q = new QuickSort();
		for(int i =0;i<180000;++i) {
			quickArr[i] = rand.nextInt(10000);
		}
		long startTime = System.currentTimeMillis();
		q.sort(quickArr);
		long stopTime = System.currentTimeMillis();
		long timeElapsed = stopTime - startTime;



		System.out.println(timeElapsed);
	}

}
