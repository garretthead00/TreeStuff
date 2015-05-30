package boxbuilder;
import java.util.ArrayList;

/**
 *
 * @author Garrett
 */
public class BoxBuilder {
    
    private Node node;
    private static Tree tree;
    private int width;
    private ArrayList<Node> boxes;
    public int nodeCounter=1;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {

        BoxBuilder builder = new BoxBuilder(5);
        ArrayList<Node> boxList = builder.getBox();       
        System.out.println(boxList);
        System.out.println();
        for (Node box : boxList){
            System.out.println(box + "\t | Parent: " + box.getParent() + "\t | Children: " + box.getChildren());
            
        }
        
        
        System.out.println("\n\n________________Size Test___________");
        System.out.print("Tree Descendent count: " + tree.getNumberOfDescendants(boxList.get(boxList.size()-1)) + "\n");
        System.out.print("Tree Node count: " + tree.getNumberOfNodes() + "\n");
        /**
        System.out.println("\n\nMod List---\n");
        for(int x = 0; x<=10;x++){
        System.out.print(x + "%5= " + (x%5) +"\n");
        }
        
        
        
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
		
        */

    }
    
    public BoxBuilder(int N){
        boxes = new ArrayList<>();
        width = N;
    
    }
    
    public void addNFamily(int N, Node n, boolean tag){
        //String tag = getBoxTag(N);        
        n.addChild(new Node(getBoxTag(tag)));
        Node temp = n.getChildAt(0);       
        for(int i=0; i<N;i++){temp.addChild(new Node(n.data));}
    }
    
    public ArrayList<Node> getBox(){
        boxes = new ArrayList<>();
        Boolean tag = true;
        BuildBox(width,boxes, tag);
        boxes =tree.getPostOrderTraversal();
        return boxes;
        
    }
    public void BuildBox(int N, ArrayList<Node> boxlist, boolean tag){
        
           boxes=boxlist;
            if(N==1){
                node = new Node(getBoxTag(tag));
                tree = new Tree(node);
            }
            else{
                BuildBox(N-2,boxes, tag);
                boxes = tree.getPostOrderTraversal();
                System.out.println(boxes);
                for(Node kid : boxes){                    
                    //If first index of postorder
                    if(kid == boxes.get(0)){
                        addNFamily(N, kid,!tag);
                    }
                    if(kid.hasChild()){
                        Node youngest = kid.getChildAt(0);
                        if(kid.data == youngest.data){
                            addNFamily(1,kid,tag);
                        } 
                    }
                }                
            }
        }
    // if : ?
    public String getBoxTag(boolean tag){  if(tag){return "X";}  return "O";    }  
}
