package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderPrintByLevel(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) {
            queue.offer(root);
        }

        TreeNode cur;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size;i++) {
                cur = queue.poll();
                System.out.print(cur.val + "->");
                temp.add(cur.val);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            result.add(temp);
            System.out.println();

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(-1);
        root.right.right = new TreeNode(18);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);

//        List<Integer> result = levelOrder(root);
//        for(int i: result)
//            System.out.println(i + "-> ");


        List<List<Integer>> levelOrderTraversalBylevel = levelOrderPrintByLevel(root);

    }
}
