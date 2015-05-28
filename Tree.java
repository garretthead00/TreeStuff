package treestuff;
import java.util.ArrayList;

/**Class: Tree
 * This class will create and manipulate the Tree of generic type T using the Nodes<T> and the methods
 * @author Garrett Head
 * @param <T>
 */
public class Tree<T> {

	private Node<T> root;

	/** This constructor will create the root of the Tree using the Node<T> r passed in
        * @param r 
        **/
	public Tree(Node<T> r) {
		this.root = r;
	}

	/** This method will check to see if the Tree is empty; returning a boolean whether true or false **/
	public boolean isEmpty() {
		return (root == null) ? true : false;
	}

	/** This method will return the Node root from the Tree **/
	public Node<T> getRoot() {
		return root;
	}

	/** This method will set the root of the Tree to the Node passed through **/
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/** This method will check whether or not a Node exist in the Tree by passing in a key
	 * and returning the boolean passed back by the find method
	 */
	public boolean exists(T key) {
		return find(root, key);
	}

	/** This returns the number of nodes by calling the getNumberOfDescendants */
	public int getNumberOfNodes() {
		return getNumberOfDescendants(root)+1;
	}

	/** This method will return the number of descendants of the Node in the Tree */
	public int getNumberOfDescendants(Node<T> node) {
		int n = node.getChildren().size(); // get the number of kids in the list
		for (Node<T> child : node.getChildren())
			n+= getNumberOfDescendants(child); // for each child in the list; the sum
		return n;
	}

	/** This method returns a boolean if the method has found a match in the Tree **/
	private boolean find(Node<T> node, T keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode)) // if the Node's data matches the key
			return true; // Node found 1
		else { 
			for (Node<T> child : node.getChildren()) //for each child in the Node passed in
				if (find(child, keyNode)) // Recursively call find until a match in found
					res = true; // 1 if found
		}
		return res;
	}
	
	@SuppressWarnings("unused")
	/** This method will clone a list of Nodes in the list to a new Node list and returns the newList */
	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<Node<T>>(); // create a new Node list
		for (Node<T> node : list) // for each node in the list
			newList.add(new Node<T>(node)); // add the node to the newList
		return newList;
	}
	
	/****************************PRE ORDER TRAVERSAL*****************************/
	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node); 
		for (Node<T> child : node.getChildren()) {
			buildPreOrder(child, preOrder); // Recursively call this method until a leaf is found;
		}
	}
	
	/** This method will return the preOrder arranged list **/
	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder); // calls the recursive function preOrder
		return preOrder;
	}

	/***********************POST ORDER TRAVERSAL********************************/
	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;
	}

	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child : node.getChildren()) {
			buildPostOrder(child, postOrder);
		}
		postOrder.add(node);
	}
}
