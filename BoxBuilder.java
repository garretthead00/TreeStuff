package boxbuilder;
import java.util.ArrayList;

/**
 *
 * @author Garrett
 */
public class BoxBuilder {
    
    private Node node;
    private Tree tree;
    private int width;
    private ArrayList<Node> boxes;
    
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {

        BoxBuilder builder = new BoxBuilder(7);

        System.out.print(builder.getBox());
    }
    
    public BoxBuilder(int N){
        boxes = new ArrayList<>();
        width = N;
    
    }
    
    public void addNFamily(int N, Node n){
        String tag = getBoxTag(N);
        n.addChild(new Node(tag));
        Node temp = n.getChildAt(0);
        for(int i=0; i<N;i++){temp.addChild(new Node(tag));}
    }
    
    public ArrayList<Node> getBox(){
      // boxes = new ArrayList<>();
        BuildBox(width,boxes);
        boxes =tree.getPostOrderTraversal();
        return boxes;
        
    }
    public void BuildBox(int N, ArrayList<Node> boxlist){
        
           boxes=boxlist;
            if(N==1){
                node = new Node("X");
                tree = new Tree(node);
            }
            
                
                BuildBox(N-2,boxes);
                boxes = tree.getPostOrderTraversal();
                for(Node kid : boxes){                    
                    //If first index of postorder
                    if(kid == boxes.get(0)){
                        addNFamily(N, kid);
                    }
                    if(kid.hasChild()){
                        Node youngest = kid.getChildAt(kid.getChildren().size()-1);
                        if(kid.data == youngest.data){
                            addNFamily(1,kid);
                        } 
                    }
                }                
            
        }
    
    public String getBoxTag(int N){
        
        if(N==1 || N%5 ==0){ return "X";}
        return "O";
    }
    
    
}
