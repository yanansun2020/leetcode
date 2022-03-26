package oa.gg;

import tree.TreeNode;

public class HouseRobberPath {
    public int rob(TreeNode root) {
        int[] values = dfs(root);
        return values[0] > values[1] ? values[0] : values[1];
    }
    //return values[0] rob cur node
    //values[1] not rob the current node
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        //if select to rob cur node
        int v1 = node.val + left[1] + right[1];
        //if select to not rob the cur node
        int v2 = Math.max(left[0], left[1])  + Math.max(right[0], right[1]);
        return new int[]{v1,v2};
    }
}
