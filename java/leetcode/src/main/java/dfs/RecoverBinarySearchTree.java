package dfs;

import tree.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode pre1 = null;
    TreeNode pre2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        getWrongNodes(root);
        int tmp = pre1.val;
        pre1.val = pre2.val;
        pre2.val = tmp;
    }

    private void getWrongNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        getWrongNodes(node.left);
        if (pre != null && node.val < pre.val) {
            pre2 = node;
            if (pre1 == null) {
                pre1 = pre;
            }
        }
        pre = node;
        getWrongNodes(node.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree recover = new RecoverBinarySearchTree();
        TreeNode node = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        recover.recoverTree(node);
    }
}
