package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import Graph.DjikstraGraph.Vertex;

public class TopologicalSort {

    /*
    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that
    for every directed edge uv, vertex u comes before v in the ordering.
    Topological Sorting for a graph is not possible if the graph is not a DAG.
     */

    private static Stack<Vertex> topSort(DjikstraGraph graph) {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : graph.getAllVertices()) {
            if (!visited.contains(vertex))
                topSortHelper(vertex, stack, visited);
        }

        return stack;

    }

    private static void topSortHelper(Vertex vertex, Stack<Vertex> stack, Set<Vertex> visited) {
        visited.add(vertex);

        for (Vertex neighbor : vertex.getAdjacentVertices()) {
            if (!visited.contains(neighbor))
                topSortHelper(neighbor, stack, visited);
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        DjikstraGraph graph = new DjikstraGraph(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        Stack<Vertex> result = topSort(graph);

        while(!result.isEmpty()) {
            System.out.println(result.pop().id);
        }

    }
}
