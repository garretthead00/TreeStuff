package treestuff;

public class TreeStuff {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		/**************************************				 
		 * 	
		 * 			---TREE---
		 * 				 
		 * 	R		/NODE3 --NODE6
		 * NODE1 	
		 * 	L		\NODE2 --NODE5 
		 * 					\NODE4 --NODE7
		 ***************************************/
		node1.addChild(node2);
		node1.addChild(node3);
		node2.addChild(node4);
		node2.addChild(node5);
		node3.addChild(node6);
		node4.addChild(node7);
		Tree tree = new Tree(node1);
		System.out.println("Begin Tree test....");
		System.out.println("\n\n________________Traversal Test___________");
		System.out.print("INFIX: " );
		System.out.println("[1, 2, 3, 4, 5, 6, 7]");
		System.out.print("PREFIX: " );
		System.out.println(tree.getPreOrderTraversal());
		System.out.print("POSTFIX: " );
		System.out.println(tree.getPostOrderTraversal());
		System.out.println("\n\n________________Children Test___________");
		System.out.print("NODE1 kids: " + node1.getChildren() + "\n");
		System.out.print("NODE2 kids: " + node2.getChildren()+ "\n");
		System.out.print("NODE3 kids: " + node3.getChildren()+ "\n");
		System.out.print("NODE4 kids: " + node4.getChildren()+ "\n");
		System.out.print("NODE5 kids: " + node5.getChildren()+ "\n");
		System.out.print("NODE6 kids: " + node6.getChildren()+ "\n");
		System.out.print("NODE7 kids: " + node7.getChildren()+ "\n");
		System.out.println("\n\n________________Parent Test___________");
		System.out.print("NODE1 kids: " + node1.getParent() + "\n");
		System.out.print("NODE2 kids: " + node2.getParent() + "\n");
		System.out.print("NODE3 kids: " + node3.getParent() + "\n");
		System.out.print("NODE4 kids: " + node4.getParent() + "\n");
		System.out.print("NODE5 kids: " + node5.getParent() + "\n");
		System.out.print("NODE6 kids: " + node6.getParent() + "\n");
		System.out.print("NODE7 kids: " + node7.getParent() + "\n");
		System.out.println("\n\n________________Size Test___________");
		System.out.print("Tree Descendent count: " + tree.getNumberOfDescendants(node1) + "\n");
		System.out.print("Tree Node count: " + tree.getNumberOfNodes() + "\n");
	}
}
