package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  // Pre order -> root - left - right
    public static void preOrderRecursive(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        result.add(root.val);
        preOrderRecursive(root.left, result);
        preOrderRecursive(root.right, result);

    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    public static List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<TreeNode> stk = new Stack<>();
        if(root != null)
        {
            stk.push(root);
        }
        TreeNode current;
        while(!stk.empty()) {
            current = stk.pop();
            result.add(current.val);
            if(current.right != null)
                stk.push(current.right);
            if(current.left != null)
                stk.push(current.left);
        }

        return result;
    }

    // Inorder -> left - root - right

    public static List<Integer> inOrderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        inOrderRecursive(root, result);
        return result;
    }

    private static void inOrderRecursive(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        inOrderRecursive(root.left, result);
        result.add(root.val);
        inOrderRecursive(root.right, result);
    }

    private static List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stk = new Stack<>();
       while(true) {
           if(root != null)
           {
               stk.push(root);
               root = root.left;
           }
           else {
               if(stk.empty()) break;
               root = stk.pop();
               result.add(root.val);
               root = root.right;
           }
       }
       return  result;
    }

    private static void pushTillLeftSubtreeIsExhausted(TreeNode current, Stack<TreeNode> stk) {
        while(current.left != null)
        {
            stk.push(current);
            current = current.left;
        }

    }

    private static void postOrderTraversal(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.val);
    }

    private static List<Integer> postOrderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        postOrderTraversal(root, result);
        return result;
    }

//    private static List<Integer> postOrderIterative(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(-1);
        root.right.right = new TreeNode(18);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);

        List<Integer> preOrderRecursive = preOrderTraversal(root);
        List<Integer> preOrderIterative = preOrderIterative(root);
        List<Integer> inOrderRecursive = inOrderTraversalRecursive(root);
        List<Integer> postOrderRecursive = postOrderTraversalRecursive(root);
        List<Integer> inOrderIterative = inOrderIterative(root);

        for(int i: postOrderRecursive)
            System.out.println(i + "-> ");
    }
}
