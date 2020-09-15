
/**
 * Binary Search Tree Class 
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 *
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	/**
	 * Return value from the public add method
	 */
	protected boolean addReturn;
	/**
	 * Return value from the public delete method
	 */
	protected E deleteReturn;
	
	/**
	 * pre : The object to insert must implement the Comparable interface
	 * @param item The object being inserted
	 * @return true if the object is inserted, false if the object is already in tree
	 */
	
	public boolean add(E item) {
		root = add(root,item);
		return addReturn;
	}

	/**
	 * Finds the target object in tree if it the tree contains
	 * @param target The object to be searched
	 * @return true if the target is in tree, otherwise false
 	 */
	public boolean contains(E target) {
		if (find(root,target) == null) 	return false;
		return true;
	}

	/**Started method find
	 * pre : The target object must implement the Comparable interface
	 * @param target The Comparable object being sought
	 * @return The object, if found, otherwise null
	 */
	public E find(E target) {
		return find(root,target);
	}

	/**Started method delete
	 * post : The object is not in tree.
	 * @param target The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in tree
	 * @throws ClassCastException if target does not implement Comparable
	 *
	 */
	public E delete(E target) {
		root = delete(root,target);
		return deleteReturn;
	}

	/**
	 * Remove the target object if the tree contains that
	 * @param target The object to be deleted
	 * @return true if the tree contains the object, otherwise false
	 */
	public boolean remove(E target) {
		 if(!contains(target)) {
	            return false;
	        }
		 else{
			 root = delete(root,target);
			 return true;
		 }
	}
	
	/**Recursive find method
	 * @param localRoot The local subtree's root
	 * @param target The object being sought
	 * @return The object, if found, otherwise null
	 */
	private E find(Node<E> localRoot,E target) {
		if(localRoot == null)
			return null;
		
		int compResult = target.compareTo(localRoot.data);
		if(compResult == 0)
			return localRoot.data;
		else if(compResult < 0)
			return find(localRoot.left,target);
		else 
			return find(localRoot.right,target);
	}
	
	/**
	 * Recursive add method.
	 * post : The data field add return is set true if the item is added to the tree, false if the item is already in tree.
	 * @param localRoot The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item){
		if(localRoot == null) {
			addReturn = true;
			return new Node<E>(item);
		}
		else if(item.compareTo(localRoot.data) == 0) {
			addReturn = false;
			return localRoot;
		}
		else if(item.compareTo(localRoot.data) < 0) {
			localRoot.left = add(localRoot.left,item);
			return localRoot;
		}
		else {
			localRoot.right = add(localRoot.right,item);
			return localRoot;
		}
		
	}
	
	/**Recursive delete method.
	 * post : The item is not in the tree;
	 * deleteReturn is equal to the deleted item 
	 * as it was stored in the tree or null if the item was not found
	 * @param localRoot The root of the current subtree
	 * @param item The item to be deleted 
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> delete(Node<E> localRoot, E item){
		if(localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		
		int compResult = item.compareTo(localRoot.data);
		if(compResult < 0) {
			localRoot.left = delete(localRoot.left,item);
			return localRoot;
		}
		else if(compResult > 0) {
			localRoot.right = delete(localRoot.right,item);
			return localRoot;
		}
		else {
			deleteReturn = localRoot.data;
			if(localRoot.left == null) {
				return localRoot.right;
			}
			else if(localRoot.right == null) {
				return localRoot.left;
			}
			else {
				if(localRoot.left.right == null) {
					localRoot.data = localRoot.left.data;
					localRoot.left = localRoot.left.left;
					return localRoot;
				}
				else {
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
		
	}
	
	/**Find the node that is the 
	 * inorder predecessor and replace it 
	 * with its left child(if any).
	 * post : The inorder predecessor is removed from the tree.
	 * @param parent The parent of possible inorder predecessor(ip)
	 * @return The data in the ip
	 */
	protected E findLargestChild(Node<E> parent) {
		if(parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		}
		else {
			return findLargestChild(parent.right);
		}
	}
	
	

}
