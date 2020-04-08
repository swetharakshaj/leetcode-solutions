package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int v; //num of vertices
    private LinkedList<Integer> adj[];

    Graph(int vertices) {
        v = vertices;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while(queue.size()!=0) {
            s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = adj[s].listIterator();

            while(i.hasNext()) {
                int temp = i.next();
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
        }
    }

    void printLevelOfNode(int s) {
        int[] level = new int[v];
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        level[s] = 0;

        while(queue.size() != 0) {

            s = queue.poll();
            System.out.println(s + " is at level " + level[s]);
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int temp = i.next();

                if(!visited[temp]) {
                    queue.add(temp);
                    visited[temp] = true;
                    level[temp] = level[s] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 0);

        System.out.println("******");
        g.BFS(1);
        g.printLevelOfNode(0);
    }
}
