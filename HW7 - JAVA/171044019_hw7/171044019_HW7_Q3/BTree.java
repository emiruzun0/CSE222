/** An implementation of the B-tree. A B-tree is a search tree
in which each node contains n data items where n is between
(order-1)/2 and order-1. (For the root, n may be between 1
and order-1.) Each node not a leaf has n+1 children. The tree is
always balanced in that all leaves are on the same level, i.e.,
of the path from the root to a leaf is constant.
the length @author Koffman and Wolfgang
 */
public class BTree<E extends Comparable<E>> {
	//Nested class

	/**
	 * A Node represents a node in a B-tree.
	 */
	private static class Node<E> {
		// Data Fields
		/**
		 * The number of data items in this node
		 */
		private int size = 0;
		/**
		 * The information
		 */
		private E[] data;
		/**
		 * The links to the children. child[i] refers to the subtree of
		 * children < data[i] for i < size and to the subtree
		 * of children > data[size-1] for i == size
		 */
		private Node<E>[] child;

		/**
		 * Create an empty node of size order
		 *
		 * @param order The size of a node
		 */
		@SuppressWarnings("unchecked")
		public Node(int order) {
			data = (E[]) new Comparable[order-1];
			child = (Node<E>[]) new Node[order];
			size = 0;
		}
	}
	
	private E newParent;
	private Node<E> newChild;

	/**
	 * The root node.
	 */
	private Node<E> root = null;
	/**
	 * The maximum number of children of a node
	 */
	private int order;

	/**
	 * Construct a B-tree with node size order
	 *
	 * @param order the size of a node
	 */
	public BTree(int order) {
		this.order = order;
		root = null;
	}
	
	public void add(E item) {
		insert(root,item);
	}

	/** Recursively insert an item into the B-tree. Inserted
    item must implement the Comparable interface
    @param root The local root
    @param item The item to be inserted
    @return true if the item was inserted,
    false if the item is already in the tree
	 */
	private boolean insert(Node<E> root, E item) {
		int index = binarySearch( item,root.data,0, root.size);
		if (index != root.size && item.compareTo(root.data[index]) == 0) {
			return false;
		}
		newChild = new Node<>(order);
		if (root.child[index] == null) {
			if (root.size < order-1) {
				insertIntoNode(root, index, item, null);
				newChild = null;
			} else {
				splitNode(root, index, item, null);
			}
			return true;
		} else {
			boolean result = insert(root.child[index], item);
			if (newChild != null) {
				E newParent = null;
				if (root.size < order-1) {
					insertIntoNode(root, index, newParent, newChild);
					newChild = null;
				} else {
					splitNode(root, index, newParent, newChild);
				}
			}
			return result;
		}
	}


	private void splitNode(Node<E> node, int index, E item, Node<E> child) {
		// Create new child
		newChild = new Node<E>(order);
		// Determine number of items to move
		int numToMove = (order-1) - ((order-1) / 2);
		// If insertion point is in the right half, move one less item
		if (index > (order-1) / 2) {
			numToMove--;
		}
		// Move items and their children
		System.arraycopy(node.data, order - numToMove - 1,
				newChild.data, 0, numToMove);
		System.arraycopy(node.child, order - numToMove,
				newChild.child, 1, numToMove);
		node.size = order - numToMove - 1;
		newChild.size = numToMove;
		// Insert new item
		if (index == ((order-1) / 2)) { // Insert as middle item
			newParent = item;
			newChild.child[0] = child;
		} else {
			if (index < ((order-1) / 2)) { // Insert into the left
				insertIntoNode(node, index, item, child);
			} else {
				insertIntoNode(newChild, index - ((order-1) / 2) - 1, item, child);
			}
			// The rightmost item of the node is the new parent
			newParent = node.data[node.size - 1];
			// Its child is the left child of the split-off node
			newChild.child[0] = node.child[node.size];
			node.size--;
		}
		// Remove items and references to moved items
		for (int i = node.size; i < node.data.length; i++) {
			node.data[i] = null;
			node.child[i + 1] = null;
		}
	}

	/** Method to insert a new value into a node
    @pre node.data[index-1] < item < node.data[index];
    @post node.data[index] == item and old values are moved right one position
    @param node The node to insert the value into
    @param index The index where the inserted item is to be placed
    @param child The right child of the value to be inserted
	 */
	private void insertIntoNode(Node<E> node, int index, E obj, Node<E> child) {
		for (int i = node.size; i > index; i--) {
			node.data[i] = node.data[i - 1];
			node.child[i + 1] = node.child[i];
		}
		node.data[index] = obj;
		node.child[index + 1] = child;
		node.size++;
	}

	int binarySearch(E target, E[] data, int first, int last){
		if (first == last)
			return first;
		if (last- first == 1){
			if ( target.compareTo(data[first]) <=0) {
				return first;
			}
			else{
				return last;
			}
		}

		int middle = first + (last -first) /2;
		int compResult = target.compareTo(data[middle]);
		if(compResult==0){
			return middle;
		}
		if (compResult<0){
			return binarySearch(target,data,first,middle);
		}
		else{
			return binarySearch(target,data,middle+1,last);
		}
	}

	
}

