package Graph;

import java.util.*;

public class DjikstraGraph {

    boolean isDirected;
    ArrayList<Edge> edgeList;
    Map<Long, Vertex> verticesMap;

    public DjikstraGraph(boolean isDirected) {
        this.isDirected = isDirected;
        edgeList = new ArrayList<>();
        verticesMap = new HashMap<>();
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public Vertex getVertex(long id) {
        return verticesMap.get(id);
    }

    public List<Edge> getAllEdges() {
        return this.edgeList;
    }

    public Collection<Vertex> getAllVertices() {
        return this.verticesMap.values();
    }

    public void setDataForVertex(Integer data, long id) {
        if(verticesMap.containsKey(id)) {
            verticesMap.get(id).setData(data);
        }
    }

    public void addEdge(long id1, long id2, int weight) {
        Vertex v1 = null;
        if(verticesMap.containsKey(id1)) {
            v1 = verticesMap.get(id1);
        }
        else {
            v1 = new Vertex(id1);
            verticesMap.put(id1, v1);
        }

        Vertex v2 = null;
        if(verticesMap.containsKey(id2)) {
            v2 = verticesMap.get(id2);
        }
        else {
            v2 = new Vertex(id2);
            verticesMap.put(id2, v2);
        }

        Edge edge = new Edge(v1, v2, weight, this.isDirected);
        edgeList.add(edge);
        v1.addAdjacentVertex(edge, v2);
        if(!isDirected) {
            v2.addAdjacentVertex(edge, v1);
        }
    }


   public class Vertex {
        long id;
        private Integer data;
        private ArrayList<Edge> edgeList;
        private ArrayList<Vertex> adjacentVertices;

//        Vertex(long id) {
//            this.id = id;
//            this.edgeList = new ArrayList<>();
//            this.adjacentVertices = new ArrayList<>();
//        }

        Vertex(long id) {
            this.id = id;
            this.edgeList = new ArrayList<>();
            this.adjacentVertices = new ArrayList<>();
        }

        long getId() {
            return this.id;
        }

        void setData(Integer data) {

            this.data = data;
        }

        Integer getData() {
            return this.data;
        }

        void addAdjacentVertex(Edge edge, Vertex vertex) {
            this.edgeList.add(edge);
            this.adjacentVertices.add(vertex);
        }

        List<Vertex> getAdjacentVertices() {
            return this.adjacentVertices;
        }

        List<Edge> getAllEdges() {
            return this.edgeList;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (id != other.id)
                return false;
            return true;
        }

    }


    public class Edge {
        int weight;
        Vertex vertex1;
        Vertex vertex2;
        boolean isDirected;

        public Edge(Vertex vertex1, Vertex vertex2, int weight) {
            this.weight = weight;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = false;
        }

        public Edge(Vertex vertex1, Vertex vertex2, int weight, boolean isDirected) {
            this.weight = weight;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = isDirected;
        }

        int getWeight() {
            return this.weight;
        }

        boolean isDirected() {
            return this.isDirected;
        }

        Vertex getFromVertex() {
            return this.vertex1;
        }

        Vertex getToVertex() {
            return this.vertex2;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
            result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (vertex1 == null) {
                if (other.vertex1 != null)
                    return false;
            } else if (!vertex1.equals(other.vertex1))
                return false;
            if (vertex2 == null) {
                if (other.vertex2 != null)
                    return false;
            } else if (!vertex2.equals(other.vertex2))
                return false;
            return true;
        }

        public void printEdge() {
            if(!isDirected) {
                System.out.println(this.vertex1.id + "--" + this.vertex2.id + " with weight " + this.weight);
            }
            else {
                System.out.println(this.vertex1.id + "-->" + this.vertex2.id + " with weight " + this.weight);
            }
        }
    }
}
