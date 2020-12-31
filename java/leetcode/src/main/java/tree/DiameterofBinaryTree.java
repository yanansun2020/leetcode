package tree;

import org.junit.Test;

public class DiameterofBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        getMAxLength(root);
        return ans - 1;
    }
    public int getMAxLength(TreeNode node){
        if (node == null) {
            return 0;
        }
        int left = getMAxLength(node.left);
        int right = getMAxLength(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    @Test
    public void test(){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        TreeNode root = TreeNode.buildTree(nums);
        int diameter = diameterOfBinaryTree(root);
    }
}
