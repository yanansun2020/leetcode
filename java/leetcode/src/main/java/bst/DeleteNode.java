package bst;

import tree.TreeNode;

public class DeleteNode {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), null);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node, 3);
    }
    public void deleteNode(TreeNode root, int key) {
        if (root == null) {
            return ;
        }
        if (root.val > key) {
            deleteNode(root.left, key);
        } else if (root.val < key) {
            deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                root.val = findMin(root.right).val;
                deleteNode(root.right, root.val);
            }
           // return root.left != null? root.left : root.right;
        }
        //return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }
}
