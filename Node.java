package treestuff;
import java.util.ArrayList;
import java.util.List;

/** Class Node:
 * This class will create a Node of the generic type T.
 * This class will contain methods to manipulate Nodes in the Game Tree.
 * @author Garrett Head
 * @param <T>
 */
public class Node<T> {

	private T data;
	private List<Node<T>> children;
	private Node<T> parent;

	/** Constructor
	 * This will create a Node assigning it the T data value passed through && created the children for the Node
	 */
	public Node(T data) {
		this.data = data;
		this.children = new ArrayList<Node<T>>(); // create the list of children
	}

	/** Constructor
	 * This will be passed a Node node and will assign the data value of the Node && create the children
	 */
	public Node(Node<T> node) {
		this.data = (T) node.getData();
		children = new ArrayList<Node<T>>(); // create the list of children
	}

	/** This method will add a child Node to THIS by passing in the Node child; */
	public void addChild(Node<T> child) {
		child.setParent(this); // assign the parent to the child Node
		children.add(child); // add
	}

	/** This method will add a new Child to the index value for the ArrayList<Gnode<T>> **/
	public void addChildAt(int index, Node<T> child) {
		child.setParent(this);
		this.children.add(index, child);
	}

	/** This method will assign the parent of the entire children list to the Node **/
	public void setChildren(List<Node<T>> children) {
		for (Node<T> child : children){	child.setParent(this); 	}
		this.children = children; // Assign the list to the children list passed in
	}

	/** This method will remove the children list from the Node **/
	public void removeChildren() {	this.children.clear();	}

	// This method will remove a individual child at a given index an return the removed Node; when returned; push/enqueue the returned Node
	public Node<T> removeChildAt(int index) { return children.remove(index);	}

	/** This method will Access and return the data of the Node **/
	public T getData() { return this.data;	}

	/** This method will update the data of the Node by pasing the data in*/
	public void setData(T data) {	this.data = data; }

	/** This method will return the parent of the Node */
	public Node<T> getParent() {	return this.parent;	}

	/** This method will assign the Parent of the Node calling the method  **/
	public void setParent(Node<T> parent) {	this.parent = parent;	}

	/** This method will return the children list of the Node **/
	public List<Node<T>> getChildren() { return this.children; }

	/** This will return the child of the Node at the specified index **/
	public Node<T> getChildAt(int index) {	return children.get(index); }

	/** This method will return a boolean of the comparison of data between different Nodes **/
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		// If object and Node have the same data type; Use the wild card to match any type and compare the data
		if (obj instanceof Node) { if (((Node<?>) obj).getData().equals(this.data)) {return true;}}
		// not equal
		return false;
	}
	
	/** This method will return a String of the data in the Node **/
	public String toString() { return this.data.toString();	}
}
