package Graph;

import java.util.*;

public class Graph {

    private boolean directed;
    private HashMap<Node, LinkedList<Node>> adjacencyMap;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public Set<Node> getAllNodes() {
        return adjacencyMap.keySet();
    }

    public void addEdge(Node source, Node destination) {
        if(!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, new LinkedList<>());
        if(!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, new LinkedList<>());
        addEdgeHelper(source, destination);
        if(!directed)
            addEdgeHelper(destination, source);

    }
    private void addEdgeHelper(Node source, Node destination) {
        LinkedList<Node> neighbors = adjacencyMap.get(source);
        if(!neighbors.isEmpty())
            neighbors.remove(destination);
        neighbors.add(destination);
        adjacencyMap.put(source, neighbors);
    }

    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.keySet().contains(source) && adjacencyMap.get(source).contains(destination);
    }

    public void printEdge() {
        for(Node node : adjacencyMap.keySet()) {
            System.out.print("Node "+ node.name+ " has neighbours: ");
            for(Node neighbor: adjacencyMap.get(node)) {
                System.out.print(neighbor.name + " ");
            }
            System.out.println();
        }
    }

    public void bfs(Node node) {
        if(node == null || !adjacencyMap.keySet().contains(node)) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.visited) continue;
            curr.visit();
            System.out.print(curr.name + "-> ");
            for(Node neighbor : adjacencyMap.get(curr)){
                if(!neighbor.visited)
                    queue.offer(neighbor);
            }
        }
    }

    public void dfs(Node node) {
        if(node == null || !adjacencyMap.keySet().contains(node)) return;
        node.visit();
        System.out.print(node.name + " -> ");
        for(Node neighbor : adjacencyMap.get(node)){
            if(!neighbor.visited)
                dfs(neighbor);
        }
    }

}
