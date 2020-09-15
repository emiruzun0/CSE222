import java.util.*;

/**
 * LinkedArrayList class
 * @author Emirhan Uzun / 171044019
 * @param <E> This means generic
 */
public class LinkedArrayList <E> extends AbstractList<E> implements List<E>{

    /**
     * This is the data numbers in the list
     */
    private int size = 0;
    
    private myNode <E> head = null;
    private myNode <E> tail = null;
  
    /**
     * This constructor initialize the capacity of node arrays
     * @param capacity Nodes array capacity
     */
    public LinkedArrayList (int capacity) {
        myNode.CAPACITY = capacity;
    }

    /**
     * This method calls the addIndex method. Because it includes the index for data
     * @param data This is what we want to add to list
     * @return Returns true always
     */
    public boolean add(E data) {
    	addIndex(size,data);
    	return true;
    }
    
    /*public void addFirst(E data) {
    	listIterator(0).add(data);
    }*/
    
   
    /**
     * This method calls the iterator constructor 
     * @param index It points to place for adding data
     * @param data This is what we want to add to list
     */
    public void addIndex(int index, E data) {
        listIterator(index).add(data) ; 
    }
    
    /**
     * This method calls the iterator constructor 
     * @param index It points to place for removing data
     * @return Returns null every time.Actually, I wrote void for this method but in AbstracList class, this method's return type is E.
     */
    public E remove(int index) {
    	listIterator(index).remove();
		return null;
    }

    /**
     * This method gives us the data in given index
     * @param index Points to the element's place which we get
     * @return Returns data in that index
     */
    public E get(int index) throws IndexOutOfBoundsException{
    	if ( ( index < 0 ) || ( index > size ) ) {
            throw new  IndexOutOfBoundsException("Invalid index " + index);

        }
        return listIterator(index).next();
    }
    
    /*
    public E getFirst() {
    	return listIterator(0).next();
    }*/
    
    /*
    public E getLast() {
    	return listIterator(size).next();
    }*/
    
    public int size() {
    	return size;
    }


    /**
     * This method calls the iterator to point place in given index
     * @param index This is the index which we go to there
     * @return Returns the iterator 
     */
    public ListIterator<E> listIterator(int index){
		return new MyListIterator(index); 
	}
    
    
    /**
     * First, this method calls the first element of list.And then it prints all elements
     */
    public void printArrays() {
        System.out.println("This is the nodes ");

        MyListIterator  it = (MyListIterator)listIterator(0);

        it.printArrays();
    }



    
    /**
     * This is private class in My Linked ArrayList class.
     * This class is used for navigate through the list 
     *
     */
    private class MyListIterator implements ListIterator <E> {

      private myNode <E> nextItem = null;
      private myNode <E> lastItemReturned = null;
      private int nodeArrayIndex = 0;
      private int lastArrayIndex = 0;
      private int totalIndex = 0;

      /**
       * LinkedArrayListMyListIterator constructor
       * @param index at which the MyListIterator will point.
       */
      public MyListIterator(int index) {
          if ( ( index < 0 ) || ( index > size ) ) {
              throw new  IndexOutOfBoundsException("Invalid index " + index);

          }

          myNode <E> temp = head;
          int counter = 0;
          lastItemReturned = null;
          
          //This loop is for that, For example, if the index is 5, and in first node we have 3 elements. It goes
          //one time next and then then initalize the node index to 2. Because 5-3 = 2. 
          while ( temp != null ) {
              if ( index >= counter + temp.getUsed()) {
                  if ( temp.next != null ) {
                      counter += temp.getUsed();
                      temp = temp.next;
                      continue;
                  }
                  if ( index - counter >= myNode.CAPACITY) {
                      nodeArrayIndex = 0;
                      nextItem = null;
                      totalIndex = index;
                      return;
                  }
              }
              nodeArrayIndex = index - counter;
              nextItem = temp;
              totalIndex = index;
              return;
          }
      }
      /**
       * Indicate whether movement forward is defined
       * @return Returns true if same node has next item or if list has next node 
       */
      public boolean hasNext() {
			return (nextItem != null || nodeArrayIndex < nextItem.getUsed()) ;
		}


    /** Move the iterator forward and return the next item.
        @return The next data in the list
        @throws NoSuchElementException if there is no such object
     */

      public E next() {
          if ( ! hasNext()) {
              throw new NoSuchElementException();
          }

          lastItemReturned = nextItem;
          lastArrayIndex = nodeArrayIndex;

          //This condition is for that, if we have next item in same node,return that
          if ( nodeArrayIndex + 1 < nextItem.getUsed()) {
              ++nodeArrayIndex;
              ++totalIndex;
              return lastItemReturned.getItem(lastArrayIndex);
          }

          //This initializing is for that, if we don't have next item, then go to next node and returns the last index of previous node.
          nextItem = nextItem.next;
          nodeArrayIndex = 0;
          ++totalIndex;
          return lastItemReturned.getItem(lastArrayIndex);
      }

      /** 
       * This method indicate whether movement backward is defined.
       * @return Returns true if same node has previous item or if list has previous node 
       */
      public boolean hasPrevious() {
			return (nextItem == null && size != 0 || nextItem.prev != null);
		}
      
      /**
     * Move the iterator backward and return the previous item
     * @return The previous data in the list
     * @throws NoSuchElementException if there is no such object
     */
    public E previous() {
          if ( !hasPrevious()){
              throw new NoSuchElementException();
          }

          --totalIndex;

          if ( nodeArrayIndex > 0 ) {
              --nodeArrayIndex;
          } 
          else {
              if ( nextItem == null ) {
                  nextItem = tail;
              } else {
                  nextItem = nextItem.prev;
              }
              nodeArrayIndex = nextItem.getUsed() - 1;
          }
          lastItemReturned = nextItem;
          lastArrayIndex = nodeArrayIndex;

          return nextItem.getItem(nodeArrayIndex);

      }

    
    /**
     * @return the element index 
     */
    public int nextIndex() {
          return totalIndex;
      }

      /**
     * @return the previous element index
     */
    public int previousIndex() {
          return totalIndex - 1;
      }

    /**
     * This function adds the data to the list
     *@param obj This is the data which we want to add
     */
    public void add(E data) {

          if ( head == null ) {
              head = new myNode <E> ();
              tail = head;
              head.AddData(data);
              nextItem = head;
              nodeArrayIndex = 0;
              System.out.println( data + " was inserted to head ");
          } 
          else if( nextItem != null ){
              E tmpItem = nextItem.addToIndex(nodeArrayIndex, data);

              if ( tmpItem != null ){             
                  if ( ( nextItem.next != null ) && (nextItem.next.getUsed() < myNode.CAPACITY-1) ){
                      nextItem.next.addToIndex(0, tmpItem);
                  } 
                  else {
                      myNode <E> newmyNode = new myNode<E>();
                      newmyNode.AddData(tmpItem);

                      newmyNode.next = nextItem.next;
                      System.out.println("\n*****This node and next node is full.");
                      System.out.println("The new node was created between this and next node. " + data + " was inserted ******\n");
                      if (nextItem.next != null) {
                          nextItem.next.prev = newmyNode;
                      } 
                      else {
                          // If the myNode we've created is the last myNode in the list,
                          // make it the 'tail'.
                          tail = newmyNode;
                      }

                      nextItem.next = newmyNode;
                      newmyNode.prev = nextItem ;
                      System.out.println(tmpItem + " was shifted to new created node");

                      
                   }	
               }
              System.out.println(data + " was inserted to node at index " + nodeArrayIndex);
          } 
          else {    
              myNode <E> newmyNode = new myNode <E>();
              newmyNode.AddData(data);
              tail.next = newmyNode;
              newmyNode.prev = tail;
              tail  = newmyNode;
              nextItem = tail;
              nodeArrayIndex = 0;     
              System.out.println("\n******The new node was created and " + data + " was inserted at index " + nodeArrayIndex);
          }

          if ( ++nodeArrayIndex >= myNode.CAPACITY) {
              nextItem = nextItem.next;
              nodeArrayIndex = 0;
          }
          ++totalIndex;
          ++size;
          
          lastItemReturned = null;

      }

      /**
     * This method remove the element from node.
     * If the node array is empty after remove,then we connect nextItem's next and nextItem's prev.
     */
    public void remove() {
          System.out.println(nextItem.getItem(nodeArrayIndex) + " was removed from node in index " + totalIndex);
          nextItem.RemoveAt(nodeArrayIndex);
          --totalIndex;
          --size; 
          
          if ( nodeArrayIndex > 0 ) { 
              --nodeArrayIndex;
          }
           
          if ( nextItem.getUsed() == 0) {
              if ( nextItem.next == null ) {
                  tail = nextItem.prev;
                  if ( tail == null ) {
                      head = null;
                  } 
                  else {
                      tail.next = null;
                  }
              } 
              else {
                  nextItem.next.prev = nextItem.prev;
              }

              if ( nextItem.prev == null ) {
                  head = nextItem.next;
                  if ( head != null ) {
                      head.prev = null;
                  } 
                  else {
                      tail = null;
                  }
              } 
              else {
            	  nextItem.prev.next = nextItem.next;
              }
          }
          lastItemReturned = null;
      }

      /**
     * Prints the elements in arrays of nodes.
     */
    public void printArrays() {
          while ( nextItem != null) {
        	  System.out.println("-------------------------------");
              System.out.println("This node has " + nextItem.getUsed() + " element(s) ");
              for (int i=0; i< nextItem.getUsed(); ++i) {
                  System.out.printf("%d----",nextItem.getItem(i) );
              }
              System.out.println("\nThis node ends ");
              nextItem  = nextItem.next;
          }
      
      }
      
	/**
	 * I create this method just for don't get the error for implement methods.
	 * Because if I don't write this method, LinkedArrayList class is not an implementation class.
	 */
	public void set(E e) {		
	}

  }



	/**
	 * This is inner class whose names is myNode.
	 * This class is used for specify next and prev nodes, and keep the arrays in it.
	 * @author Emirhan Uzun / 171044019
	 * @param <E> This means generic class
	 */
    private static class myNode <E> {
	    private E[] arrays ;
	    private int arrayUsed;
	    private static int CAPACITY = 2;
	
	    private myNode<E> next = null;
	    private myNode<E> prev = null;
	
	    /**
	     * This constructor creates an array for node with capacity.
	     */
	    private myNode() {
	      arrays = (E[]) new Object[CAPACITY];
	      arrayUsed = 0;	
	    }
	
	    /**
	     * @param data add the data to last of node array
	     */
	    private void AddData(E data) {
	        if ( arrayUsed >= CAPACITY ) {
	            throw new ArrayIndexOutOfBoundsException("Node Array full");
	        }
	
	        arrays[arrayUsed] = data;
		    arrayUsed++;
	    }
	
	    /**
	     * @param index Index which we want to remove the data in it 
	     * @return It returns the data of array in that index.
	     */
	    private E RemoveAt(int index) {
	        E temp = getItem(index);
	        --arrayUsed;
	        for ( int i = index; i < arrayUsed; ++i) {
	            arrays[i] = arrays[i+1];
	        }
	        return temp;
	    }
	
	    /**
	     * Get the item of index
	     * @param index Index which we want to see the data in it 
	     * @return It returns the data of array in that index.
	     */
	    private E getItem(int index) {
	        if ( ( index >= arrayUsed ) || ( index < 0 ) ) {
	            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
	        }
	        return arrays[index];
	    }
	
	
	    /** 
	     * This method adds a data to index in the myNode array
	     * @param index The index to the array location to be inserted at
	     * @data The data item to be inserted
	     * @throws ArrayIndexOutOfBoundsException if the index is not in interval
	     * @return If the array was already full, returns the last element of array or returns null.
	     */
	    private E addToIndex(int index, E data) {
	        if ( ( index >= CAPACITY ) || ( index < 0 ) ) {
	            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
	        }
	        
	        E temp = null;
	        if ( arrayUsed == CAPACITY) {
	        	temp = arrays[arrayUsed-1];
	        }
	        int i = arrayUsed;
	        while(i > index) {
	        	if(i != CAPACITY ) arrays[i] = arrays[i-1];
	        	i--;
	        }
	        arrays[index] = data;
	        if (arrayUsed < CAPACITY ) {
	            ++arrayUsed;
	        }
	        return temp;
	    }
	
	    
	    /**
	     * Gives us the size
	     * @return the number of used size in array
	     */
	    private int getUsed() {
	        return arrayUsed;
	    }
	
	  }
}

