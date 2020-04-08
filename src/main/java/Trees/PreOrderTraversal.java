package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    private static List<Integer> preOrder(Node root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)
            return output;
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty())
        {
            Node temp = nodes.pop();
            output.add(temp.getVal());
            Collections.reverse(temp.getChildren());
            for(Node child: temp.getChildren()){
                nodes.push(child);
            }
        }
        return output;
    }
}
