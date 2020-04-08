package Graph;

public class Node {
    int n;
    String name;
    boolean visited;

    Node(int n, String name) {
        this.n= n;
        this.name = name;
        this.visited = false;
    }

    void visit(){
        this.visited = true;
    }

    void unVisit() {
        this.visited = false;
    }
}
