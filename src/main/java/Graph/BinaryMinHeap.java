package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryMinHeap<T> {

    class Node {
        T key;
        int weight;
    }

    ArrayList<Node> allNodes = new ArrayList<>();
    HashMap<T, Integer> positionMap = new HashMap<>();

    public boolean contains(T data) {
        return positionMap.keySet().contains(data);
    }

    public void add(T key, int weight) {
        Node node = new Node();
        node.key = key;
        node.weight = weight;
        allNodes.add(node);
        int currIndex = allNodes.size()-1;
        int parentIndex = (currIndex - 1)/2;
        positionMap.put(node.key, currIndex);

        while(parentIndex >= 0) {
            Node currNode = allNodes.get(currIndex);
            Node parentNode = allNodes.get(parentIndex);
            if(parentNode.weight > currNode.weight) {
                swap(parentNode, currNode);
                updatePosition(parentNode.key, currNode.key, parentIndex, currIndex);
                currIndex = parentIndex;
                parentIndex = (parentIndex -1) / 2;
            }
            else {
                break;
            }
        }
    }

    public T min() {
        return allNodes.get(0).key;
    }

    public boolean isHeapEmpty() {
        return allNodes.isEmpty();
    }

    public void decreaseWeight(T key, int newWeight) {
        Integer currIndex = positionMap.get(key);
        allNodes.get(currIndex).weight = newWeight;
        int parentIndex = (currIndex-1)/ 2;
        while(parentIndex >= 0) {
            Node currNode = allNodes.get(currIndex);
            Node parentNode = allNodes.get(parentIndex);
            if(parentNode.weight > currNode.weight) {
                swap(parentNode, currNode);
                updatePosition(parentNode.key, currNode.key, parentIndex, currIndex);
                currIndex = parentIndex;
                parentIndex = (parentIndex -1) / 2;
            }
            else {
                break;
            }
        }
    }

    public Integer getWeight(T key) {
        Integer pos = positionMap.get(key);
        if(pos == null) return null;
        return allNodes.get(pos).weight;

    }

    public Node extractMinNode() {
        Node minNode = new Node();
        minNode.key = allNodes.get(0).key;
        minNode.weight = allNodes.get(0).weight;
        int size = allNodes.size()-1;
        allNodes.get(0).key = allNodes.get(size).key;
        allNodes.get(0).weight = allNodes.get(size).weight;
        positionMap.remove(minNode.key);
        positionMap.remove(allNodes.get(0).key);
        positionMap.put(allNodes.get(0).key, 0);
        allNodes.remove(size);
        size--;
        int currIndex = 0;
        while(true) {
            int left = 2*currIndex +1;
            int right = 2*currIndex +2;
            if(left > size) break;
            if(right> size) right = left;
            int smallerindex = allNodes.get(left).weight <  allNodes.get(right).weight ? left : right;
            if(allNodes.get(currIndex).weight > allNodes.get(smallerindex).weight)
            {
                swap(allNodes.get(currIndex), allNodes.get(smallerindex));
                updatePosition(allNodes.get(currIndex).key, allNodes.get(smallerindex).key, currIndex, smallerindex);
                currIndex = smallerindex;
            }
            else {
                break;
            }
        }
        return minNode;

    }
    private T extractMin() {
        return extractMinNode().key;
    }

    private void updatePosition(T key, T key1, int pos, int pos1) {
        positionMap.remove(key);
        positionMap.remove(key1);

        positionMap.put(key, pos);
        positionMap.put(key1, pos1);
    }

    private void swap(BinaryMinHeap<T>.Node parentNode, BinaryMinHeap<T>.Node currNode) {
        T data = parentNode.key;
        int weight = parentNode.weight;

        parentNode.key = currNode.key;
        parentNode.weight = currNode.weight;

        currNode.key = data;
        currNode.weight = weight;
    }

    public boolean isEmpty() {
        return allNodes.size() == 0;
    }
}
