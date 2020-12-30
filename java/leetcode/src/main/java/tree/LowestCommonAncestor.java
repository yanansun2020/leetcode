package tree;

import org.junit.Test;

/**
 * Each node has two properties [findp, findq]
 * if both are true, then the node is the LCA
 */
public class LowestCommonAncestor {
    /**
     * solution1
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        //top down, the first one meet is the result, if they are on the same tree
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor_1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null? left : right;
    }

    /**
     * solution2
     */
    TreeNode res;
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfs(root, p, q);
        return res;
    }

    public int[] dfs(TreeNode node, TreeNode p, TreeNode q){
        int[] flag = new int[2];
        if (node == null) {
            return flag;
        }
        if (node.val == p.val) {
            flag[0] = 1;
        }
        if (node.val == q.val) {
            flag[1] = 1;
        }
        int[] leftFlag = dfs(node.left, p, q);
        int[] mergedLeft = mergeFlag(flag, leftFlag);
        if (findBoth(mergedLeft)) {
            res = node;
            return new int[]{0, 0};
        }
        int[] rightFlag = dfs(node.right, p, q);
        int[] mergedRight = mergeFlag(mergedLeft, rightFlag);
        if (findBoth(mergedRight)) {
            res = node;
            return new int[]{0, 0};
        }
        return mergedRight;
    }

    public int[] mergeFlag(int[] flag1, int[] flag2){
        int[] res = new int[2];
        res[0] = flag1[0] | flag2[0];
        res[1] = flag1[1] | flag2[1];
        return res;
    }

    public boolean findBoth(int[] flag){
        return flag[0] == 1 && flag[1] == 1;
    }
    @Test
    public void test(){
        Integer[] arr = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.buildTree(arr);
        TreeNode ans = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(7));
    }
}
