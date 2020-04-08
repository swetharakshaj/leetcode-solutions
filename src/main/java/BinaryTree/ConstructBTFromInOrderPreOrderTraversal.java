package BinaryTree;

public class ConstructBTFromInOrderPreOrderTraversal {

    private static TreeNode constructTree(int[] inorder, int[] preorder) {
        return helper(0, 0, inorder.length-1, inorder, preorder);
    }

    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] inorder, int[] preorder) {
        if(preStart > preorder.length-1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = helper(preStart+1, inStart, inIndex-1, inorder, preorder);
        root.right = helper(preStart+1+inIndex-inStart, inIndex+1, inEnd, inorder, preorder);

        return root;


    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3, 9, 20, 15, 7};

        TreeNode root = constructTree(inorder, preorder);
        System.out.println(root.val);

    }
}
