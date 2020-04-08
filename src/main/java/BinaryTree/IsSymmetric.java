package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSymmetric {

    public static boolean isBTSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return false;
//        if(root.left.val != root.right.val) return false;
        Queue<TreeNode> s1 = new LinkedList<>();
        Queue<TreeNode> s2 = new LinkedList<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        s1.offer(left);
        s2.offer(right);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int size1 = s1.size();
            int size2 = s2.size();
            for (int i = 0; i < size1; i++) {
                TreeNode s1Node = s1.poll();
                TreeNode s2Node = s2.poll();
                if(s1Node == null && s2Node == null) continue;
                if(s1Node == null || s2Node == null) return false;
                if (s1Node.val != s2Node.val)
                    return false;

                s1.offer(s1Node.left);
                s1.offer(s1Node.right);
                s2.offer(s2Node.right);
                s2.offer(s2Node.left);

            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(0);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(8);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);

        System.out.println(isBTSymmetric(root));

    }


//    private static void pushChildren(Stack<BinaryTree.TreeNode> s1, BinaryTree.TreeNode s1Node) {
//        s1.push(s1Node.left);
//        s1.push()
//    }
}
