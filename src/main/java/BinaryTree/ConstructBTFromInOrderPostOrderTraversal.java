package BinaryTree;

import Trees.Node;

public class ConstructBTFromInOrderPostOrderTraversal {

    private static TreeNode constructTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private static TreeNode helper(int postIndex, int inStart, int inEnd, int[] inorder, int[] postOrder) {


        if (inStart > inEnd || postIndex < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postIndex]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.right = helper(postIndex - 1, inIndex + 1, inEnd, inorder, postOrder);
        root.left = helper(postIndex - inEnd + inIndex - 1, inStart, inIndex - 1, inorder, postOrder);

        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};

        TreeNode root = constructTree(inorder, postOrder);
        System.out.println(root.val);

    }
}
