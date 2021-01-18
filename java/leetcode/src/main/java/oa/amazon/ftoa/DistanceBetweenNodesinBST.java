package oa.amazon.ftoa;

import tree.TreeNode;

public class DistanceBetweenNodesinBST {
    int getDistanceBetweenNodes(TreeNode root, TreeNode nodeA, TreeNode nodeB){
        TreeNode lowestCommonAncestor = getLCA(root, nodeA, nodeB);
        Integer leftDis = getDistance(lowestCommonAncestor, nodeA);
        Integer rightDis = getDistance(lowestCommonAncestor, nodeB);
        return leftDis + rightDis;
    }

    Integer getDistance(TreeNode root, TreeNode child){
        if (root.val == child.val) return 0;
        TreeNode node = root.left;
        if (root.val < child.val) {
            node = root.right;
        }
        return 1 + getDistance(node, child);
    }

    /**
     * get lowest common ancestor
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return root;
        }
        //top down, the first one meet is the result, if they are on the same tree
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null? left : right;
    }
}
