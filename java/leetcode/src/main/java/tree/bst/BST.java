package tree.bst;

import tree.TreeNode;

/**
 * search in a BST depends on the height of the BST
 * The height of a tree range from logn to n
 * problem with the insert method: If the given values are increasing or decreasing
 * The tree will be a list
 *
 *e.g. 50, 40, 35, 30 will form the following BST:
 *             50
 *             /
 *            40
 *            /
 *           35
 *           /
 *         30
 */
public class BST {
    public TreeNode findMin(TreeNode root){
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
    public TreeNode findMax(TreeNode root){
        while (root != null && root.right != null){
            root = root.right;
        }
        return root;
    }
    public boolean contains(TreeNode root, TreeNode node){
        if (root == null) {
            return false;
        }
        if (node.val < root.val) {
            return contains(root.left, node);
        } else {
            return contains(root.right, node);
        }
    }

    public TreeNode insert(TreeNode root, int value){
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.val) {
            root.left = insert(root.left, value);
        }else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public TreeNode remove(TreeNode root, int value){
        if (root == null) {
            return null;
        }
        if (value == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
            TreeNode minNodeFromRight = findMin(root.right);
            root.val = minNodeFromRight.val;
            root.right = remove(root.right, minNodeFromRight.val);
        }
        if (value < root.val) {
            root.left = remove(root.left, value);
        }
        if (value > root.val) {
            root.right = remove(root.right, value);
        }
        return root;
    }
}
