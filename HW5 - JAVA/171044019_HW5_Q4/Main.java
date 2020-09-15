/**
 * This is the test main class.All method was tested
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 *
 */
public class Main {

	/**
	 * @param args String arguments
	 * @throws Exception If methods finds an error or don't complete the methods
	 */
	public static void main(String[] args) throws Exception {
		MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
		heap.add(new AgeData(10));
		heap.add(new AgeData(5));
		heap.add(new AgeData(70));
		heap.add(new AgeData(10));
		heap.add(new AgeData(50));
		heap.add(new AgeData(5));
		heap.add(new AgeData(15));
		
		
		//heap.remove(new AgeData(10));
		
		System.out.println("The people number is in age 10 : " + heap.find(new AgeData(10)).toString());
		System.out.println("\n\n");
		
		System.out.println("Younger than 10 : " + heap.youngerThan(10));
		System.out.println("Older than 10 : " + heap.olderThan(10));

		String heapStr = heap.toString();
		System.out.println(heapStr);
		
	}
	
	

}
