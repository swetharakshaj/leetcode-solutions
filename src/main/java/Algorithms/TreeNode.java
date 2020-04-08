package Algorithms;


public class TreeNode {

     int val;
     TreeNode leftChild;
     TreeNode rightChild;

    TreeNode(int val) {
        this.val = val;
        this.leftChild = null;
        this.rightChild = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.leftChild = left;
        this.rightChild = right;
    }
}
