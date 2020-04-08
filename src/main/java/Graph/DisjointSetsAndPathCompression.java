package Graph;

import java.util.HashMap;

public class DisjointSetsAndPathCompression {

    HashMap<Long, Node> map = new HashMap<>();
    class Node {
        long data;
        int rank;
        Node parent;
    }

    /*
    Methods to implement :
    makeSet
    union
    findSet
     */

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1.data == parent2.data) return false;
        if(parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank==parent2.rank? parent1.rank+1 : parent1.rank;
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;
        }
        return true;
    }

    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if(parent.data == node.data)
            return parent;
        node.parent = findSet(parent);
        return node.parent;
    }
}
