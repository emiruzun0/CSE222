import java.util.*;
/**
 * This is my queue class which keeps adds' and removes' elements
 * @author Emirhan Uzun / 171044019	
 * @since 04/05/2020
 *
 */
public class MyDeque<E> extends AbstractCollection<E> implements Deque<E>{

	/**
	 * Deque List's first element
	 */
	private myNode <E> front = null;
    /**
     * Deque List's last element
     */
    private myNode <E> rear = null;
    /**
     * Garbage List's first element
     */
    private myNode <E> front2 = null;
    /**
     * Deque List's size
     */
    private int size = 0;
    /**
     * Garbage List's size
     */
    private int size2 = 0;
   
	/**
	 * This method add the element to end of the list
	 */
	@Override
	public boolean offer(E data) {
		if(data == null)	return false;
		offerLast(data);
		return true;
	}
	
    
	/**
	 *This method add the element to front of the list.
	 *Also if the garbage list is not empty, than uses that nodes.
	 */
	@Override
	public boolean offerFirst(E data) {
		if(data == null)	return false;
		myNode<E> temp;
		if(size2 != 0) {
			 temp = front2;
			 temp.data = data;
			 front2 = front2.next;
			 size2--;
			 System.out.println("The node was taken from garbage list ");
		}
		else {
			 temp = new myNode<E>(data);
		}
        if(size == 0) {
            front = temp;
            rear = temp;
        }
        else{
        	temp.next = front;
        	front.prev = temp;
    		front=temp;
        }
		System.out.println("The element " + data + " is inserted to the front of deque");
        size++;
        return true;
		
	}
	
	/**
	 *This method add the element to rear of the list.
	 *Also if the garbage list is not empty, than uses that nodes.
	 */
	@Override
	public boolean offerLast(E data) {
		if(data == null)	return false;
		myNode<E> temp;
		if(size2 != 0) {
			 temp = front2;
			 temp.data = data;
			 front2 = front2.next;
			 size2--;
			 System.out.println("The node was taken from garbage list ");
		}
		else {
			 temp = new myNode<E>(data);
		}
		if(size == 0) {
			front = temp;
            rear = temp;
		}
		else{
			rear.next = temp;
			temp.prev = rear;
			rear = temp;
		}
		System.out.println("The element " + data + " is inserted to the rear of deque");
		size++;
		return true;
		
	}
	
	/**
	 *This method add the element to rear of the list.
	 */
	@Override
	public boolean add(E data) {
		if(data == null)	return false;
		addLast(data);
		return true;
	}
	
	
	/**
	 *This method add the element to front of the list.
	 *Also if the garbage list is not empty, than uses that nodes.
	 *@throws NullPointerException If the data is null
	 */
	@Override
	public void addFirst(E data) throws NullPointerException{
		if(data == null)	throw  new NullPointerException("This data is null ! ");
		myNode<E> temp;
		if(size2 != 0) {
			 temp = front2;
			 temp.data = data;
			 front2 = front2.next;
			 size2--;
			 System.out.println("The node was taken from garbage list ");
		}
		else {
			 temp = new myNode<E>(data);
		}
        if(size == 0) {
            front = temp;
            rear = temp;
        }
        else{
        	temp.next = front;
        	front.prev = temp;
    		front=temp;
        }
		System.out.println("The element " + data + " is inserted to the front of deque");

        size++;
		
	}
	
	/**
	 *This method add the element to rear of the list.
	 *Also if the garbage list is not empty, than uses that nodes.
	 *@throws NullPointerException If the data is null
	 */
	@Override
	public void push(E data) {
		if(data == null)	throw  new NullPointerException("This data is null ! ");
		myNode<E> temp;
		if(size2 != 0) {
			 temp = front2;
			 temp.data = data;
			 front2 = front2.next;
			 size2--;
			 System.out.println("The node was taken from garbage list ");
		}
		else {
			 temp = new myNode<E>(data);
		}
        if(size == 0) {
            front = temp;
            rear = temp;
        }
        else{
        	temp.next = front;
        	front.prev = temp;
    		front=temp;
        }
		System.out.println("The element " + data + " is inserted to the front of deque");

        size++;
		
	}

	/**
	 *This method add the element to rear of the list.
	 *Also if the garbage list is not empty, than uses that nodes.
	 *@throws NullPointerException If the data is null
	 */
	@Override
	public void addLast(E data) {
		if(data == null)	throw  new NullPointerException("This data is null ! ");
		myNode<E> temp;
		if(size2 != 0) {
			 temp = front2;
			 temp.data = data;
			 front2 = front2.next;
			 size2--;
			 System.out.println("The node was taken from garbage list ");
		}
		else {
			 temp = new myNode<E>(data);
		}
		if(size == 0) {
			front = temp;
            rear = temp;
		}
		else{
			rear.next = temp;
			temp.prev = rear;
			rear = temp;
		}
		System.out.println("The element " + data + " is inserted to the rear of deque");
		size++;
	}
	
	/**
	 *This method removes the element from rear of the list.
	 *Also puts removed node to the front of garbage list
	 *@return Returns the removed node's data.
	 */
	@Override
	public E poll() {
		if (size == 0) {
			System.out.println("The deque is empty ! ");
			return null;
		}
		
		myNode <E> temp = rear;
        rear = rear.prev;
        if ( rear == null ) {
            front = null;
        } 
        else {
            rear.next = null;
        }
        --size;
        
        if(size2 == 0) {
            front2 = temp;
        }
        else{
        	temp.next = front2;
    		front2=temp;
        }
		++size2;
		System.out.println("The last element " + temp.data + " is removed and is moved to the garbage list.");
		printGarbageElements();
        return temp.data;
	}
	
	/**
	 *This method removes the element from front of the list.
	 *Also puts removed node to the front of garbage list
	 *@return Returns the removed node's data.
	 */
	@Override
	public E pollFirst() {
		if (size == 0) {
			System.out.println("The deque is empty ! ");
			return null;
		}
		else {
			myNode <E> temp = front;
			front = front.next;
			--size;
			
			if(size2 == 0) {
	            front2 = temp;
	        }
	        else{
	        	temp.next = front2;
	    		front2=temp;
	        }
			++size2;
			System.out.println("The first element " + temp.data + " is removed and is moved to the garbage list.");
			printGarbageElements();
			return temp.data;
		}
	}

	/**
	 *This method removes the element from rear of the list.
	 *Also puts removed node to the front of garbage list
	 *@return Returns the removed node's data.
	 */
	@Override
	public E pollLast() {
		if (size == 0) {
			System.out.println("The deque is empty ! ");
			return null;
		}
		
		myNode <E> temp = rear;
        rear = rear.prev;
        if ( rear == null ) {
            front = null;
        } 
        else {
            rear.next = null;
        }
        --size;
        
        if(size2 == 0) {
            front2 = temp;
        }
        else{
        	temp.next = front2;
    		front2=temp;
        }
		++size2;
		System.out.println("The last element " + temp.data + " is removed and is moved to the garbage list.");
		printGarbageElements();
        return temp.data;
	}
	
	/**
	 *This method removes the element which in parameter if the object is found.
	 *Also puts removed node to the front of garbage list
	 *@param o The object which is removed if it found
	 *@throws NoSuchElementException If the element is not found
	 *@return Returns true if the data was removed 
	 */
	@Override
	public boolean remove(Object o) {
	    if (iterator(0).remove(o) == null) throw new NoSuchElementException("This element " + o + " was not found ! ") ;
	    return true;
	}
	
	
	/**
	 *This method removes the element from rear of the list.
	 *Also puts removed node to the front of garbage list
	 *@throws NoSuchElementException If the deque is empty.
	 *@return Returns the removed node's data.
	 */
	@Override
	public E remove() throws NoSuchElementException{
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		else {
			myNode <E> temp = front;
			System.out.println("The first element " + temp.data + " is removed and is moved to the garbage list.");
			front = front.next;
			--size;
			if(size2 == 0) {
	            front2 = temp;
	        }
	        else{
	        	temp.next = front2;
	    		front2=temp;
	        }
			++size2;
			printGarbageElements();
			return temp.data;
		}
	}

	/**
	 *This method removes the element from front of the list.
	 *Also puts removed node to the front of garbage list
	 *@throws NoSuchElementException If the deque is empty.
	 *@return Returns the removed node's data.
	 */
	@Override
	public E removeFirst() throws NoSuchElementException{
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		else {
			myNode <E> temp = front;
			System.out.println("The first element " + temp.data + " is removed and is moved to the garbage list.");
			front = front.next;
			--size;
			if(size2 == 0) {
	            front2 = temp;
	        }
	        else{
	        	temp.next = front2;
	    		front2=temp;
	        }
			++size2;
			printGarbageElements();
			return temp.data;
		}
	}

	/**
	 *This method removes the element from rear of the list.
	 *Also puts removed node to the front of garbage list
	 *@throws NoSuchElementException If the deque is empty.
	 *@return Returns the removed node's data.
	 */
	@Override
	public E removeLast() throws NoSuchElementException{
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
	
		myNode <E> temp = rear;
        rear = rear.prev;
        if ( rear == null ) {
            front = null;
        } 
        else {
            rear.next = null;
        }
        --size;
        if(size2 == 0) {
            front2 = temp;
        }
        else{
        	temp.next = front2;
    		front2=temp;
        }
		++size2;
		System.out.println("The last element " + temp.data + " is removed and is moved to the garbage list. ");
		printGarbageElements();
        return temp.data;
	}
	
	
	
	/**
	 * The front of the queue represented by this deque
	 * @return Returns the front of deque, or null if it is empty
	 */
	@Override
	public E peek() {
		if (size == 0) return null;
		return front.getItem();
	}
	
	/**
	 * The front of the queue represented by this deque
	 * @return Returns the front of deque, or null if it is empty
	 */
	@Override
	public E peekFirst() {
		if (size == 0)	return null;
		return front.getItem();
	}

	/**
	 * The rear of the queue represented by this deque
	 * @return Returns the rear of deque, or null if it is empty
	 */
	@Override
	public E peekLast() {
		if (size == 0) return null;
		return rear.getItem();
	}
	
	
	/**
	 * The front of the queue represented by this deque
	 * @throws NoSuchElementException if the deque is empty
	 * @return Returns the front of deque
	 */
	@Override
	public E getFirst() throws NoSuchElementException{
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		return front.getItem();
	}

	/**
	 * The rear of the queue represented by this deque
	 * @throws NoSuchElementException if the deque is empty
	 * @return Returns the front of deque
	 */
	@Override
	public E getLast() throws NoSuchElementException{
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		return rear.getItem();
	}
	
	/**
	 * The front of the queue represented by this deque
	 * @throws NoSuchElementException if the deque is empty
	 * @return Returns the front of deque
	 */
	@Override
	public E element() {
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		return front.getItem();
	}
    
    
	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * @param o Element to be removed from this deque, if present
	 * @return Returns true if an element was removed as a result of this call
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) {
		if (iterator(0).remove(o) == null) {
			System.out.println("This element " + o + " was not found ! ") ;
			return false;
		}
	    return true;
	}

	/**
	 * Removes the last occurrence of the specified element from this deque.
	 * @param o Element to be removed from this deque, if present
	 * @return Returns true if an element was removed as a result of this call
	 */
	@Override
	public boolean removeLastOccurrence(Object o) {
		if (iterator(size-1).removeLast(o) == null) {
			System.out.println("This element " + o + " was not found ! ") ;
			return false;
		}
	    return true;
	}


	
	/**
	 * Removes and returns the first element of this deque
	 * @throws NoSuchElementException If the deque is empty
	 * @return Returns the element at the front of this deque
	 * 
	 */
	@Override
	public E pop() throws NoSuchElementException {
		if (size == 0)	throw new NoSuchElementException("The deque is empty ! ");
		else {
			myNode <E> temp = front;
			System.out.println("The first element " + temp.data + " is removed and is moved to the garbage list.");
			front = front.next;
			--size;
			if(size2 == 0) {
	            front2 = temp;
	        }
	        else{
	        	temp.next = front2;
	    		front2=temp;
	        }
			++size2;
			printGarbageElements();
			return temp.data;
		}
	}
	
	/**
	 * Size of the deque
	 * @return Returns the size of deque
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * /**
	 * Size of the garbage list
	 * @return Returns the size of garbage list
	 */
	public int size2() {
		return size2;
	}
	
	/**
 	 * Returns true if this collection contains no elements.
 	 * @return Returns true if this collection contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	 /**
	 * Get the element present in this list at a given specific index.
	 * @param index Represents the index of the element in this list which is to be returned.
	 * @return Returns the element at the specified index in the given list.
	 * @throws IndexOutOfBoundsException  if the index is out of range
	 */
	public E get(int index) throws IndexOutOfBoundsException{
	    	if ( ( index < 0 ) || ( index > size ) ) {
	            throw new  IndexOutOfBoundsException("Invalid index " + index);

	        }
	        return iterator(index).next();
	}
	
    /**
     * Prints the element of list
     */
    public void printElements() {
    	if(size == 0)	System.out.println("This deque list is empty ! ");
    	else{
    		System.out.println("\nThis is the deque list elements :  ");

            MyIterator  it = (MyIterator) iterator(0);

            it.printElements();
            System.out.println("\n");
    	}

    }
    
    /**
     *  Prints the elements of garbage list
     */
    public void printGarbageElements() {
    	if(size2 == 0)	System.out.println("This garbage list is empty ! ");
    	else {
			 System.out.println("\nThis is the garbage list elements :  ");
	
		        myNode<E> temp = front2;
		        for (int i=0; i< size2; ++i) {
		            System.out.printf("%d --  ",temp.getItem() );
		            temp  = temp.next;
		        }
		        System.out.println("\n");
    	}
       
    }
	
	/**
	 * Returns an iterator in this deque at sepecial index
	 * @param index Represents the index of the iterator
	 * @return Returns an iterator at the specified index.
	 */
	public MyIterator iterator(int index) {
		return new MyIterator(index);
	}
	
	/**
	 * Returns an iterator over the elements in this deque in proper sequence.The elements will be returned in order from first (head) to last (tail).
	 * @return Returns an iterator over the elements in this deque in sequence
	 */
	@Override
	public MyIterator iterator() {
		return new MyIterator(0); 
	}
	

	/**
	 * Returns an iterator over the elements in this deque in reverse sequential order. The elements will be returned in order from last (tail) to first (head).
	 * @return  an iterator over the elements in this deque in reverse sequence
	 */
	@Override
	public MyIterator descendingIterator() {
		return new MyIterator(size-1); 
	}

	/**
	 * This is my inner iterator class. It implements the Iterator interface.
	 * @author Emirhan Uzun / 171044019
	 * @param <E> the type of elements returned by this iterator
	 *
	 */
	private class MyIterator implements Iterator <E>{
		 private myNode <E> nextItem = null;
	     private myNode <E> lastItemReturned = null;
	     private int totalIndex = 0;
	     
	     
		/**
		 * This constructor creates an iterator in given index
		 * @param index Represents the index of iterator
		 */
		public MyIterator(int index) {
	          if ( ( index < 0 ) || ( index > size ) ) {
	              throw new  IndexOutOfBoundsException("Invalid index " + index);

	          }
	          
	          myNode <E> temp = front;
	          lastItemReturned = null;
	          
	          for(int i =0 ; i< index ; ++i) {
	        	  temp = temp.next;
	          }
	          nextItem = temp;
	          totalIndex = index ;
	          return;
		}

		/**
		 * Removes the node from list if object is found
		 * @param o The object which is removed if it found
		 * @return Returns the removed node, if it is not removed then return null
		 */
		public myNode<E> remove(Object o) {
			while(hasNext()) {
				if(o.equals(nextItem.getItem())) {
					System.out.println(nextItem.getItem() + " was removed from queue in index " + totalIndex);
					myNode<E> temp =  nextItem;
					--totalIndex;
					--size;
					  if ( nextItem.next == null ) {
		                  rear = nextItem.prev;
		                  if ( rear == null ) {
		                      front = null;
		                  } 
		                  else {
		                      rear.next = null;
		                  }
		              } 
		              else {
		                  nextItem.next.prev = nextItem.prev;
		              }

		              if ( nextItem.prev == null ) {
		            	  front = nextItem.next;
		                  if ( front != null ) {
		                	  front.prev = null;
		                  } 
		                  else {
		                      rear  = null;
		                  }
		              } 
		              else {
		            	  nextItem.prev.next = nextItem.next;
		              }
		              
		              if(size2 == 0) {
		                  front2 = temp;
		              }
		              else{
		              	temp.next = front2;
		          		front2=temp;
		              }
		      		  ++size2;
		      		  printGarbageElements();
		              return temp;
				}
				nextItem = nextItem.next;
				++totalIndex;
			}
			return null;
		}
		
		/**
		 * Removes the node from list if object is found. It starts from last node
		 * @param o The object which is removed if it found
		 * @return Returns the removed node, if it is not removed then return null
		 */
		public myNode<E> removeLast(Object o){
			
			while(hasPrevious()) {
				if(o.equals(nextItem.getItem())) {
					System.out.println(nextItem.getItem() + " was removed from queue in index " + totalIndex);
					myNode<E> temp =  nextItem;
					--totalIndex;
					--size;
					  if ( nextItem.next == null ) {
		                  rear = nextItem.prev;
		                  if ( rear == null ) {
		                      front = null;
		                  } 
		                  else {
		                      rear.next = null;
		                  }
		              } 
		              else {
		                  nextItem.next.prev = nextItem.prev;
		              }

		              if ( nextItem.prev == null ) {
		            	  front = nextItem.next;
		                  if ( front != null ) {
		                	  front.prev = null;
		                  } 
		                  else {
		                      rear  = null;
		                  }
		              } 
		              else {
		            	  nextItem.prev.next = nextItem.next;
		              }
		              
		              if(size2 == 0) {
		                  front2 = temp;
		              }
		              else{
		              	temp.next = front2;
		          		front2=temp;
		              }
		      		  ++size2;
		      		  printGarbageElements();
		              return temp;
				}
				previous();
			}
			return null;
		}

		/**
		 * Returns true if the iteration has more elements.
		 * @return Returns true if the iteration has more elements
		 */
		@Override
		public boolean hasNext() {
			return (nextItem != null) ;
		}

		/**
		 * Returns the next element in the iteration.
		 * @return Returns the next element in the iteration
		 */
		@Override
		public E next() {
			 if ( ! hasNext()) {
	              throw new NoSuchElementException();
	          }
			 
			 lastItemReturned = nextItem;
			 nextItem = nextItem.next;
			 ++totalIndex;
			 return lastItemReturned.getItem();
		}
		
		/**
		 * If this iterator has more elements when traversing the list in the backward direction.
		 * @return Returns true if the previous item exists
		 */
		public boolean hasPrevious() {
			return (nextItem == null && size != 0 || nextItem.prev != null);
		}
		
		 /**
		 * Returns the previous element in the iteration.
		 * @return Returns the previous element in the iteration
		 */
		public E previous() {
	          if ( !hasPrevious()){
	              throw new NoSuchElementException();
	          }
	          
	          --totalIndex;
	          
	          if ( nextItem == null ) {
                  nextItem = rear;
              } else {
                  nextItem = nextItem.prev;
              }
          lastItemReturned = nextItem;

          return nextItem.getItem();
		 }
		 
				 
		 /**
		 * This method prints the elements
		 */
		public void printElements() {
              for (int i=0; i< size; ++i) {
                  System.out.printf("%d --  ",nextItem.getItem() );
	              nextItem  = nextItem.next;
              }  
	      }
		
	}
	
	/**
	 * This inner class holds datas 
	 * @author Emirhan Uzun / 171044019
	 * @since 04/05/2020
	 * @param <E> Generic
	 */
	private static class myNode <E> {
        
		private myNode<E> next = null;
	    private myNode<E> prev = null;
	    private E data;
	    
	    /**
	     * This constructor creates a node and put the data in this node.
	     * @param data 
	     */
	    public myNode(E data) {
			this.data = data;
			this.next = null;
		}
        
		/**
		 * Gets the item data
		 * @return Returns the item data
		 */
		public E getItem() {		
			return data;
		}
		
	}

}
