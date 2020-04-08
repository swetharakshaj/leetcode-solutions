package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBT {

    public static int maxDepthRecursive(TreeNode root) {
        if(root == null)
            return 0;

        int left_depth = maxDepthRecursive(root.left);
        int right_depth = maxDepthRecursive(root.right);

        return Integer.max(left_depth, right_depth)+1;

    }

    public static int maxDepthIterative(TreeNode root) {
        int depth = 0;

        if(root == null)
            return depth;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                curr = q.poll();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            depth++;

        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);




        System.out.println("Recursive : "+ maxDepthRecursive(root));
        System.out.println("Iterative : "+ maxDepthIterative(root));
    }
}
