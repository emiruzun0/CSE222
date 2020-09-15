import java.util.*;
/**
 * This heap class holds AgeData nodes and does some arraylist operations with those
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 * @param <E> Generic
 *
 */
public class MaxHeap<E extends Comparator<E>> {

	/**
	 * My Arraylist to keep nodes
	 */
	protected ArrayList<AgeData> myHeap;
	/**
	 * Comparator data field 
	 */
	Comparator<AgeData> comparator;

	/**
	 * Construct the arraylist 
	 */
	public MaxHeap() {
		myHeap = new ArrayList<AgeData>();
	}
	
	/**
	 * Construct the arraylist and comparator object
	 * @param comp comparator object
	 */
	public MaxHeap(Comparator<AgeData> comp) {
		myHeap = new ArrayList<AgeData>();
		comparator = comp;
	}

	/**
	 * Adds the object to the array list
	 * @param ageData The item to be inserted
	 */
	public void add(AgeData ageData) {
		if(myHeap.isEmpty()) {
			myHeap.add(ageData);
			return;
		}
		boolean flag = false;
		for(int i =0 ; i<myHeap.size();++i) {
			if(myHeap.get(i).compare(myHeap.get(i),ageData) == 0) {
				flag = true;
				myHeap.get(i).numOfPeople++;
				moveUp(i);
			}
		}
		if(!flag ) myHeap.add(ageData);
		moveUp(myHeap.size() - 1);
		
	}
	
	/**
	 * Remove the item from list or if the people number is greater than 1, then decreases 1
	 * @param ageData The item to be deleted
	 * @throws Exception If the heap is empty
	 */
	public void remove(AgeData ageData) throws Exception {
		if(myHeap.isEmpty()) {
			throw new Exception("The heap is empty ! ");
		}
		for(int i = 0;i<myHeap.size();++i) {
			if(myHeap.get(i).compare(myHeap.get(i),ageData) == 0 ) {
				if(myHeap.get(i).getNumOfPeople() > 1)  myHeap.get(i).numOfPeople--;
				else {
					AgeData temp = myHeap.get(myHeap.size() -1);
					myHeap.set(i, temp);
					myHeap.remove(myHeap.size() -1 );
					downUp(0);
				}
			}
		}
		downUp(0);
	}
	
	
	
	/**
	 * If the children people number is greater than parent, than swap the elements.Index starts from 0
	 * @param parent The parent index
	 */
	private void downUp(int parent) {
		while(true) {
			int leftChild = leftChild(parent);
			int rightChild = leftChild + 1;
			int maxChild = leftChild;
			
			if(leftChild >= myHeap.size()) break;
			if(rightChild < myHeap.size() && myHeap.get(rightChild).compareTo(myHeap.get(leftChild))) {
				maxChild = rightChild;
			}
			if(myHeap.get(maxChild).compareTo(myHeap.get(parent))) {
				swap(myHeap,parent,maxChild);
				parent = maxChild;
			}
			else break;
		}
	}

	/**
	 * If the children people number is greater than parent, than swap the elements.This method starts from last element
	 * @param index The index to be checked
	 */
	private void moveUp(int index) {
		while(index >= 0 && myHeap.get(index).compareTo(myHeap.get((index-1)/2))){
			swap(myHeap,index,(index-1)/2);
            index = (index-1) / 2;
		}
	}
	
	/**
	 * Swaps two objects places
	 * @param myHeap my list
	 * @param o1 swapped first object
	 * @param o2 swapped second object
	 */
	protected void swap(ArrayList<AgeData> myHeap,int o1,int o2) {	
		AgeData temp = myHeap.get(o1);
		myHeap.set(o1,myHeap.get(o2));
		myHeap.set(o2,temp);
	}
	
	/**
	 * It finds the left child's index
	 * @param pos position (parent index)
	 * @return the left child index
	 */
	private int leftChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
	

	/**
	 * It appends the nodes to the buffer
	 * @return A string that contains the objects informations
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<myHeap.size();++i) {
			sb.append(myHeap.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * @param ageData The item to be searched
	 * @return the ageData object if it is in list
	 * @throws Exception If the object isn't found, then throws exception
	 */
	public AgeData find(AgeData ageData) throws Exception {
		for(int i=0;i<myHeap.size();++i) {
			if(myHeap.get(i).compare(myHeap.get(i),ageData) == 0) {
				return myHeap.get(i);
			}
		}
		throw new Exception("The node was not found ! ");
	}

	/**
	 * It searches the list and finds the people number that is younger than given age
	 * @param age Given age to be searched younger than that
	 * @return count which is people number that are younger than given age
	 */
	public int youngerThan(int age) {
		int count = 0 ;
		for(int i=0;i<myHeap.size();++i) {
			if(myHeap.get(i).getAge() < age)  count += myHeap.get(i).getNumOfPeople();
		}
		return count;
	}
	
	/**
	 * It searches the list and finds the people number that is older than given age
	 * @param age Given age to be searched older than that
	 * @return count which is people number that are older than given age
	 */
	public int olderThan(int age) {
		int count = 0 ;
		for(int i=0;i<myHeap.size();++i) {
			if(myHeap.get(i).getAge() > age)  count += myHeap.get(i).getNumOfPeople();
		}
		return count;
	}

	
	
	 
	
	
	
}
