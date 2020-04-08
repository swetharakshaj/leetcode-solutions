package Walmart;

import java.util.HashMap;

public class LRU {

        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node()
            {

            }

            Node(int key, int val)
            {
                this.key = key;
                this.val = val;
            }
        }
        private int numOfElements;
        private int maxCapacity;
        HashMap<Integer, Node> cache;
        Node head = new Node();
        Node tail = new Node();

        public LRU(int capacity) {
            numOfElements = 0;
            maxCapacity = capacity;
            cache = new HashMap<Integer, Node>();
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key) {
            if(!cache.containsKey(key))
                return -1;
            int result = cache.get(key).val;
            removeFromList(cache.get(key));
            addToList(cache.get(key));
            return result;
        }

        public void put(int key, int value) {
            Node curr;
            if(cache.containsKey(key))
            {
                curr = cache.get(key);
                curr.val = value;
                removeFromList(curr);
            }
            else {
                if(numOfElements == maxCapacity)
                {
                    cache.remove(tail.prev.key, tail.prev);
                    removeFromList(tail.prev);
                }
                curr = new Node(key, value);
                cache.put(key, curr);
                numOfElements++;
            }
            addToList(curr);
        }

        private void removeFromList(Node node)
        {
            Node nodeBefore = node.prev;
            Node nodeAfter = node.next;
            nodeBefore.next = nodeAfter;
            nodeAfter.prev = nodeBefore;
        }

        private void addToList(Node node)
        {
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
        }


        public static void main(String[] args)
        {
            LRU lru = new LRU(2);
            lru.put(1,1);
            lru.put(2,2);
            System.out.println(lru.get(1));
            lru.put(3,3);
            System.out.println(lru.get(2));
            lru.put(4,4);
            System.out.println(lru.get(1));
            System.out.println(lru.get(3));
            System.out.println(lru.get(4));
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

