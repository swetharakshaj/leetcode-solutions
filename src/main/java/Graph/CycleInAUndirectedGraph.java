package Graph;

import Graph.DjikstraGraph.Vertex;
import Graph.DjikstraGraph.Edge;

import java.util.HashSet;
import java.util.Set;

public class CycleInAUndirectedGraph {

    private static boolean isThereACycle(DjikstraGraph graph) {
        DisjointSetsAndPathCompression ds=  new DisjointSetsAndPathCompression();

        for(Vertex vertex : graph.getAllVertices())
        {
            ds.makeSet(vertex.id);
        }

        for(Edge edge : graph.edgeList) {
            Long rep1= ds.findSet(edge.vertex1.id);
            Long rep2= ds.findSet(edge.vertex2.id);
            if(rep1 == rep2) return true;
            ds.union(edge.vertex1.id, edge.vertex2.id);
        }
        return false;
    }

//    private static boolean hasCycleDFS(DjikstraGraph graph) {
//        Set<Vertex> visited = new HashSet<>();
//        for(Vertex v : graph.getAllVertices()) {
//            if(visited.contains(v)) continue;
//            else {
//                boolean flag = hasCycleDfsHelper(v, visited, null);
//
//                if(flag)
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean hasCycleDfsHelper(Vertex v, Set<Vertex> visited, Vertex parent) {
//        visited.add(v);
//        for(Vertex neighbor : v.getAdjacentVertices()) {
//
//        }
//    }

    public static void main(String[] args) {
        DjikstraGraph graph = new DjikstraGraph(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        System.out.println(isThereACycle(graph));
    }
}
