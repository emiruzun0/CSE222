/**
 * This is the test class of MyDeque class.
 * @author Emirhan Uzun / 171044019
 * @since 04/05/2020
 *
 */
public class TestMain {

	/**
	 * @param args String
	 */
	public static void main(String[] args) {
		MyDeque<Integer> mylist = new MyDeque<Integer>();
		System.out.println("****************ADD - OFFER TEST***********");
			mylist.add(5);
			mylist.add(867);
			mylist.offerFirst(4);
			mylist.offerLast(9384);
			mylist.offerFirst(756);
			mylist.offerLast(1847);
			mylist.addLast(3923);
			mylist.offer(8413);
			mylist.offerLast(777);
			mylist.offerFirst(8413);
			mylist.addFirst(1453);
			mylist.offer(3543);
			mylist.printElements();
		System.out.println("*******************************************");
		
		
		System.out.println("****************REMOVE TEST***************");
			mylist.removeFirst();
			mylist.removeLast();
			mylist.remove(9384);
			mylist.pollFirst();
			mylist.pollLast();
			mylist.poll();
			System.out.println("This is the garbage list size : " + mylist.size2());
		System.out.println("*******************************************");
		
		System.out.println("****ADD - OFFER (CHECK IF USE GARBAGE LIST)****");
			mylist.add(2456);
			mylist.add(3620);
			mylist.offerFirst(4890);
			mylist.offerLast(3950);
			mylist.offerFirst(1359);
			System.out.println("\nThis is the garbage list size : " + mylist.size2());
			mylist.offerLast(1456);
			mylist.offer(7898);
			mylist.offerLast(6503);
			mylist.offerLast(4890);
			mylist.offerFirst(9384);
			mylist.addFirst(2253);
			mylist.printElements();
		System.out.println("*******************************************");

		
		System.out.println("****************GET AND PEEK TEST***************");
			mylist.printElements();
			System.out.println("The first element is (getFirst method) " + mylist.getFirst());
			System.out.println("The last element is (getLast method) " + mylist.getLast());
			System.out.println("The first element is (peekFirst method " + mylist.peekFirst());
			System.out.println("The last element is (peekLast method) " + mylist.peekLast());
			System.out.println("The last element is (peek method ) " + mylist.peek());
			System.out.println("The last element is (element method ) " + mylist.element());
			System.out.println("The 5.index element is (get method ) " + mylist.get(5));
		System.out.println("*******************************************");


		System.out.println("****MIX ADD AND REMOVE TEST****");
			mylist.offerFirst(777);
			mylist.addFirst(458);
			mylist.addLast(756);
			mylist.addLast(4);
			mylist.addLast(1359);
			mylist.removeLast();
			mylist.removeLast();
			mylist.offerLast(1359);
			mylist.removeFirst();
			mylist.printElements();
		System.out.println("*******************************************");
		
		System.out.println("****************REMOVE OCCURENCE TEST***************");
			mylist.printElements();
			mylist.removeFirstOccurrence(756);
			mylist.printElements();
			mylist.removeLastOccurrence(4890);
			mylist.printElements();
		System.out.println("****************************************************");
	}

}
