package tree.bst;

import org.junit.Test;
import tree.TreeNode;

/**
 * Each node should comply the range
 */
public class ValidateBinarySearchTree {
    Integer preValue;
    public boolean isValidBST(TreeNode root) {
        preValue = null;
        return isValid_(root);
    }
    public boolean isValid_(TreeNode root){
        if (root == null) {
            return true;
        }
        boolean validLeft = isValid_(root.left);
        if (preValue != null && root.val <= preValue) {
            return false;
        }
        preValue = root.val;
        boolean validRight = isValid_(root.right);
        return validLeft && validRight;
    }


    public boolean isValidBST_(TreeNode root) {
        return isValid(root, null, null);
    }
    public boolean isValid(TreeNode node, Integer min, Integer max){
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min){
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        boolean isValidLeft = isValid(node.left, min, node.val);
        if (!isValidLeft) {
            return false;
        }
        boolean isValidRight = isValid(node.right, node.val, max);
        return isValidRight;
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{5,1,4,null,null,3,6};
        TreeNode root = TreeNode.buildTree(nums);
        boolean ans = isValidBST(root);
    }
}
