import java.io.*;
import java.util.*;

/**
 * The class for a binary tree that stores type E objects 
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 * @param <E> Generic
 *
 */
public class BinaryTree<E> implements Serializable{
	

		/**
		 * Class to encapsulate a tree node
		 * @param <E> Generic
		 */
		protected static class Node<E> implements Serializable{

			/**
			 * The information stored in this node
			 */
			protected E data;
			/**
			 * Reference to the left child
			 */
			protected Node<E> left;
			/**
			 * Reference to the right child
			 */
			protected Node<E> right;
			
			/**
			 * Construct a node with given data and no children
			 * @param data The data to store in this node
			 */
			public Node(E data) {
				this.data = data;
				left = null;
				right = null;
			}
			

			/**
			 * Return a string representation of the node
			 * @return A string representation of the data fields 
			 */
			public String toString() {
				return data.toString();
			}
			
			/**
			 * Return the data
			 * @return Gets the data
			 */
			public E getData() {
				return data;
			}

			/**
			 * Sets the data with given parameter
			 * @param data New data to the node's data
			 */
			public void setData(E data) {
				this.data = data;
			}

		}
		
		/**
		 * The root of the binary tree
		 */
		private Node<E> root;
		
		/**
		 * The no-parameter constructor merely sets the data field root to null
		 */
		public BinaryTree() {
			setRoot(null);
		}
		
		/**
		 * Construct sets the data field root with given node object
		 * @param root Given node object
		 */
		protected BinaryTree(Node<E> root) {
			this.setRoot(root);
		}
		
		/**
		 * Constructs a new binary tree with data 
		 * @param data The data E object to put the node
		 * @param leftTree It is root leftTree as its left subtree
		 * @param rightTree It is root rightTree as its right subtree
		 */
		protected BinaryTree(E data, BinaryTree<E> leftTree,
				BinaryTree<E> rightTree) {
			setRoot(new Node<E>(data));
			if(leftTree != null) {
				getRoot().left = leftTree.getRoot();
			}else {
				getRoot().left = null;
			}
			if(rightTree != null) {
				getRoot().right = rightTree.getRoot();
			} else {
				getRoot().right = null;
			}
		}
		
		/**
		 * Return the left subtree
		 * @return the left subtree or null if either the root or the left subtree is null
		 */
		public BinaryTree<E> getLeftSubtree(){
			if(getRoot() != null && getRoot().left != null) {
				return new BinaryTree<E>(getRoot().left);
			}else {
				return null;
			}
		}
		
		/**
		 * Return the right subtree
		 * @return the right subtree or null if either the root or the right subtree is null
		 */
		public BinaryTree<E> getRightSubtree(){
			if(getRoot() != null && getRoot().right != null) {
				return new BinaryTree<E>(getRoot().right);
			}else {
				return null;
			}
		}
		
		/**
		 * Determine whether this tree is a leaf
		 * @return true if the root has no children
		 */
		public boolean isLeaf() {
			return (getRoot().left == null && getRoot().right == null);
		}
		
		/**
		 * Creates a string builder and then calls the recursive preOrderTraverse method
		 */
		public String toString() {
			StringBuilder sb = new StringBuilder();
			preOrderTraverse(getRoot(),1,sb);
			return sb.toString();
		}

		/**
		 * Perform a preorder traversal
		 * @param node The local root
		 * @param depth The depth
		 * @param sb The string buffer to save the output
		 */
		protected void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
			/*for(int i = 0 ; i < depth ; ++i){
				sb.append(" ");
			}*/
			if(node != null) {
				sb.append(node.toString());
				sb.append(" ");
				preOrderTraverse(node.left,depth,sb);
				preOrderTraverse(node.right,depth,sb);
			}
		}
		
		/**
		 * Method to read a binary tree.
		   pre: The input consist of a preorder traversal of the 
		   		binary tree.The line "null" indicates a null tree.
		 * @param scan the Scanner attached to the input file
		 * @return The binary tree
		 */
		public static BinaryTree<String>  readBinaryTree(Scanner scan){
			String data = scan.next();
			if(data.equals("null")) {
				return null;
			}else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data,leftTree,rightTree);

			}
		}

		/**
		 * Returns the node object
		 * @return the node object
		 */
		public Node<E> getRoot() {
			return root;
		}

		/**
		 * It sets the local root with given parameter node object
		 * @param root Given root object
		 */
		public void setRoot(Node<E> root) {
			this.root = root;
		}
		
		
}
