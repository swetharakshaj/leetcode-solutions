package BST;

public class BSTOperations {

    public class BSTNode {

        int val;
        BSTNode left;
        BSTNode right;

        BSTNode(int val) {
            this.val = val;
        }

    }


    public  BSTNode insert (BSTNode root, int val) {
        if(root == null)
            return new BSTNode(val);
        if(val < root.val)
            root.left = insert(root.left, val);
        if(val > root.val)
            root.right = insert(root.right, val);
        return root;
    }

    public BSTNode searchRecursive (BSTNode root, int target) {
        if(root == null || root.val == target)
            return root;
        if(target < root.val)
            return searchRecursive(root.left, target);
        return searchRecursive(root.right, target);
    }

    public BSTNode searchIterative(BSTNode root, int target) {
        while(root != null && root.val != target) {
            if(target < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

//    public BSTNode delete(BSTNode root)
}
