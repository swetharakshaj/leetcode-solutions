//package ActualInterview;
//
//import java.util.*;
//
//public class CloneGraph {
//
//
////
////    /*
////
////     */
////
////    From Yunlong Gao to Everyone: (01:41 PM)
//// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. 
////From Me to Everyone: (01:43 PM)
//// 4, 3, 9, 7, 4, 2, 11 
////From Yunlong Gao to Everyone: (02:07 PM)
//// Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors. 
////From Yunlong Gao to Everyone: (02:07 PM)
//// /* // Definition for a Node. class Node {     public int val;     public List<Node> neighbors;      public Node() {}      public Node(int _val,List<Node> _neighbors) {         val = _val;         neighbors = _neighbors;     } }; */ class Solution {     public Node cloneGraph(Node node) {              } } 
////    From Lei Ming to Everyone: (02:36 PM)
////             design a website: calculate the most frequent key words
////     */
//
//    //    Definition for a Node
//
//
//
//    class Node { 
//        public int val; 
//        public List<Node> neighbors;  
//
//        public Node() {
//        }  
//
//        public Node(int _val, List<Node> _neighbors)
//        {
//             val = _val; neighbors = _neighbors; 
//        }
//             
//    }
//
//
//    public Node cloneGraph(Node node)
//    {
//        // map to hold orig : copy
//        // Do BFS, populate map
//        // Iterate through map, populate copy's neighbors with map values
//
//        HashMap<Node, Node> originalCopyMap = new HashMap<>();
//        Queue<Node> queue = new LinkedList<>();
//
//
//        Node dummy = node;
//        queue.offer(dummy);
//
//        while(!queue.isEmpty())
//        {
//            Node curr = queue.poll();
//
//            if(originalCopyMap.containsKey(curr))
//                continue;
//
//            Node copy = new Node(curr.val, new ArrayList<>());
//            for(Node neighbor : curr.neighbors)
//            {
//                queue.offer(neighbor);
//            }
//
//            originalCopyMap.put(curr, copy);
//        }
//
//        for(Map.Entry<Node, Node> entry : originalCopyMap.entrySet())
//        {
//            Node original = entry.getKey();
//            Node copy = entry.getValue();
//
//            for(Node neighbor : original.neighbors)
//            {
//                copy.neighbors.add(originalCopyMap.get(neighbor));
//            }
//        }
//
//        return originalCopyMap.get(node);
//    }
//}
