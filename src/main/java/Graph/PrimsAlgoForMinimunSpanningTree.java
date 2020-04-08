package Graph;
import Graph.DjikstraGraph.Vertex;
import Graph.DjikstraGraph.Edge;
import java.util.HashMap;

import static Graph.DjikstraShortestPathFromSingleSource.getAdjacentVertex;

public class PrimsAlgoForMinimunSpanningTree {


    // Spanning tree is a subset of tree which connects all n vertices of the graph in n-1 edges
    // Minimum spanning tree : spanning tree in a weighted graph where sum of distances/ weights of n-1 edges is minimum

    private static void findMinSpanningTree(DjikstraGraph graph, Vertex source) {
        BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<Vertex>();

        HashMap<Vertex, Edge> edgeMap = new HashMap<>();

        for(Vertex v : graph.getAllVertices()) {
            minHeap.add(v, Integer.MAX_VALUE);
        }

        minHeap.decreaseWeight(source, 0);

        while(!minHeap.isEmpty()) {

           BinaryMinHeap<Vertex>.Node node = minHeap.extractMinNode();
           Vertex curr = node.key;

           // check if edgeMap has this vertex already, this won't exist for the source
            if(edgeMap.get(curr) != null) {
                edgeMap.get(curr).printEdge();
            }

           for(Edge edge : curr.getAllEdges()) {
               Vertex adjacentVertex = getAdjacentVertex(curr, edge);

               if(!minHeap.contains(adjacentVertex)) continue;

               if(minHeap.getWeight(adjacentVertex) > edge.weight) {
                   minHeap.decreaseWeight(adjacentVertex, edge.weight);
                   edgeMap.put(adjacentVertex, edge);
               }
           }
        }
    }


    public static void main(String[] args) {
        DjikstraGraph graph = new DjikstraGraph(false);

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        Vertex sourceVertex = graph.getVertex(1);

        findMinSpanningTree(graph, sourceVertex);
    }




}
