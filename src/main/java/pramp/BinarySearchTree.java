package pramp;

public class BinarySearchTree {

    Node root;

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    void insert(int key) {

        // 1) If the tree is empty, create the root
        if(this.root == null) {
            this.root = new Node(key);
            return;
        }

        // 2) Otherwise, create a node with the key
        //    and traverse down the tree to find where to
        //    to insert the new node
        Node currentNode = this.root;
        Node newNode = new Node(key);

        while(currentNode != null) {
            if(key < currentNode.key) {
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    newNode.parent = currentNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if(currentNode.right == null) {
                    currentNode.right = newNode;
                    newNode.parent = currentNode;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

//    int findLargestSmallerKey(int num) {
//
//        if(root == null) return -1;
//        while(root != null) {
//            if(root.key > num && root.left != null)
//                root = root.left;
//            else if(root.key < num && root.right != null)
//                root = root.right;
//            else
//                break;
//        }
//        return root.key;
//    }

    int findLargestSmallerKey(int num) {
        int result = -1;
        if(root == null) return result;
        while(root != null) {
            if(root.key > num)
                root = root.left;
            else if(root.key < num)
            {
                result = root.key;
                root = root.right;

            }
        }
        return result;
    }


    public static void main(String[] args) {

        // Create a Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number is " + result);

    }
}
