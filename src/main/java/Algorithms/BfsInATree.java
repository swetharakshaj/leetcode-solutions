package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BfsInATree {

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();

            System.out.println(temp.val);

            if(temp.leftChild != null)
                queue.add(temp.leftChild);
            if(temp.rightChild != null)
                queue.add(temp.rightChild);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(6);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(2);
        root.rightChild.leftChild = new TreeNode(1);
        root.rightChild.leftChild.rightChild = new TreeNode(9);
        root.rightChild.leftChild.rightChild.rightChild = new TreeNode(3);
        levelOrderTraversal(root);

    }

}
