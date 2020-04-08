package Recursion;

import java.util.LinkedList;
import java.util.List;

/*
Return all unique BS trees generated using numbers from 1 to n
 */
public class UniqueBSTII {

    class TreeNode {
        int num;
        TreeNode left;
        TreeNode right;

        TreeNode(){

        }

        TreeNode(int n)
        {
            num = n;
            left = null;
            right = null;
        }
    }
    private LinkedList<TreeNode> uniqueBSTs(int n)
    {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }

    private LinkedList<TreeNode> generateTrees(int start, int end) {

        LinkedList<TreeNode> output = new LinkedList<>();
        if(start > end)
        {
            output.add(null);
            return output;
        }

        for(int i=start; i<=end; i++)
        {
            LinkedList<TreeNode> leftTrees = generateTrees(start, i-1);
            LinkedList<TreeNode> rightTrees = generateTrees(i+1, end);

            for(TreeNode l : leftTrees)
            {
                for(TreeNode r : rightTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    output.add(root);
                }
            }
        }
        return output;
    }

    public static void main(String[] args)
    {
        UniqueBSTII  obj = new UniqueBSTII();
        LinkedList<TreeNode> list = obj.uniqueBSTs(3);
        System.out.println("output");
    }
}
