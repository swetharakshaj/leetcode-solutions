package Trees;

import java.util.List;

public class Node {

    private int val;
    private List<Node> children;

    public Node(){}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal(){
        return this.val;
    }
    public List<Node> getChildren(){
        return this.children;
    }
}
