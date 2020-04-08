package Graph;

import Graph.DjikstraGraph.Vertex;
import Graph.DjikstraGraph.Edge;


import java.util.HashMap;
import java.util.Map;

public class DjikstraShortestPathFromSingleSource {

    public static Map<Vertex, Integer> getShortestPathFromSingleSource (DjikstraGraph graph, Vertex source) {

        BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<Vertex>();

        Map<Vertex, Integer> distanceMap = new HashMap<>();

        Map<Vertex, Vertex> parentMap = new HashMap<>();

        // initialize minHeap with all vertices and weights as infinity
        for( Vertex v : graph.getAllVertices()) {
            minHeap.add(v, Integer.MAX_VALUE);
        }

        //set source distance as 0
        minHeap.decreaseWeight(source, 0);

        distanceMap.put(source, 0);
        parentMap.put(source, null);

        while(!minHeap.isEmpty()) {
            BinaryMinHeap<Vertex>.Node heapNode = minHeap.extractMinNode();
            Vertex curr = heapNode.key;

            distanceMap.put(curr, heapNode.weight);

            for(Edge edge : curr.getAllEdges()) {
                Vertex adjacent = getAdjacentVertex(curr, edge);

                if(!minHeap.contains(adjacent)) continue;

                int newdistance = distanceMap.get(curr) + edge.weight;

                if(minHeap.getWeight(adjacent) > newdistance) {
                    minHeap.decreaseWeight(adjacent, newdistance);
                    parentMap.put(adjacent, curr);
                }
            }
        }
        return distanceMap;
    }

    public static Vertex getAdjacentVertex(Vertex curr, Edge edge) {
        return edge.vertex1.equals(curr) ? edge.vertex2 : edge.vertex1;
    }


    public static void main(String args[]){
        DjikstraGraph graph = new DjikstraGraph(false);


        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        Vertex sourceVertex = graph.getVertex(1);
        Map<Vertex,Integer> distance = getShortestPathFromSingleSource(graph, sourceVertex);
        for(Map.Entry<Vertex, Integer> entry : distance.entrySet()) {
            System.out.println(entry.getKey().id + " -> " + entry.getValue());
        }
//        System.out.print(distance);
    }

}
