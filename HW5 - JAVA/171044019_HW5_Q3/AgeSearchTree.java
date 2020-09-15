/**
 * The class records the number of people in each age for a population
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 *
 */
public class AgeSearchTree<E>  extends BinarySearchTree<AgeData> {


	/**
	 * Construct the root to null
	 */
	protected AgeSearchTree() {
		root = null;
	}


	/**
	 * Add the object to the tree
	 * @param ageData The AgeData object that is to be inserted
	 * @return true if the object is inserted, otherwise false
	 */
	public boolean add(AgeData ageData) {
		root = add(root,ageData);
		return addReturn;
	}
	
	/**
	 * Recursive add method. 
	 * Insert the node to the tree
	 * @param localRoot The current node
	 * @param item The object to be inserted
	 * @return new item object if it inserted
	 */
	public Node<AgeData> add(Node<AgeData> localRoot, AgeData item){
		if(localRoot == null) {
			addReturn = true;
			return new Node<AgeData>(new AgeData(item.age));
		}
		else if(item.compareTo(localRoot.data) == 0) {
			localRoot.data.numOfPeople++;
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
	
	/**
	 * Recursive delete method.Deletes the node from tree
	 * @param localRoot The current node
	 * @param item The item to be deleted
	 * @return node that is deleted
	 */
	private Node<AgeData> delete(Node<AgeData> localRoot, AgeData item){
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
			if(localRoot.getData().getNumOfPeople() > 1) {
				localRoot.getData().numOfPeople--;
				return localRoot;
			}
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
	
	/**
	 * Remove the target object from the tree if tree contains the object
	 * @param target The object to be removed
	 * @return true if the object is in tree, otherwise false
	 */
	@Override
	public boolean remove(AgeData target) {
		 if(find(root,target) == null) {
	            return false;
	        }
		 else{
			 root = delete(root,target);
			 return true;
		 }
	}
	
	/**
	 * Finds the node in tree if node is in.
	 * @param localRoot The current node
	 * @param target The object that to be search
	 * @return the string which contains the age data fields
	 */
	private String find(Node<AgeData> localRoot,AgeData target) {
		if(localRoot == null)
			return null;
		
		int compResult = target.compareTo(localRoot.data);
		if(compResult == 0)
			return (localRoot.data).toString();
		else if(compResult < 0)
			return find(localRoot.left,target);
		else 
			return find(localRoot.right,target);
	}



	/**
	 * Prints the nodes.
	 * @return The string that contains all the nodes in tree
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(getRoot(),1,sb);
		return sb.toString();
	}

	/**
	 * It appends nodes to the buffer.
	 * @param node The current node
	 * @param depth Depth
	 * @param sb String buffer
	 */
	protected void preOrderTraverse(Node<AgeData> node, int depth, StringBuilder sb) {
		for(int i = 0 ; i < depth ; ++i){
			sb.append(" ");
		}
		if(node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.getData().getAge() + " - " + node.getData().getNumOfPeople());
			sb.append("\n");
			preOrderTraverse(node.left,depth+1,sb);
			preOrderTraverse(node.right,depth+1,sb);
		}
	}


	/**
	 * Finds the younger age from given age
	 * @param tempAge The given age
	 * @return young method's value
	 */
	public int youngerThan(int tempAge) {
		return young(root,tempAge,0);
	}


	/**
	 * @param localRoot The current node
	 * @param tempAge given age 
	 * @param count number of younger people than given age
	 * @return count 
	 */
	private int young(Node<AgeData> localRoot,int tempAge, int count) {
		if(localRoot == null)	return count;
		if(localRoot.data.age == tempAge) {
			return young(localRoot.left,tempAge,count);
		}
		else if(localRoot.data.age < tempAge) {
			count += localRoot.data.numOfPeople;
			count = young(localRoot.left,tempAge,count);
			return young(localRoot.right,tempAge,count);
		}
		else {
			return young(localRoot.right,tempAge,count);
		}
		
	}


	/**
	 * Finds the older age from given age
	 * @param tempAge The given age
	 * @return young method's value
	 */
	public int olderThan(int tempAge) {
		return old(root,tempAge,0);
	}


	/**
	 * @param localRoot The current node
	 * @param tempAge given age 
	 * @param count number of older people than given age
	 * @return count 
	 */
	private int old(Node<AgeData> localRoot, int tempAge, int count) {
		if(localRoot == null)	return count;
		if(localRoot.data.age == tempAge) {
			return old(localRoot.right,tempAge,count);
		}
		else if(localRoot.data.age > tempAge) {
			count += localRoot.data.numOfPeople;
			count = old(localRoot.right,tempAge,count);
			return old(localRoot.left,tempAge,count);
		}
		else {
			return old(localRoot.left,tempAge,count);
		}
	}


}
