package tree;

import java.util.LinkedList;
/**
 * build binary node by array
 * node.left = buildTree(nums, node, 2 * i + 1);
 * node.right = buildTree(nums, node, 2 *i + 2);
 */
public class TreeNode {
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode buildTree(Integer[] nums, int i){
        if (i >= nums.length || nums[i] == null) {
            return null;
        }
        TreeNode node = new TreeNode(nums[i]);
        node.left = buildTree(nums, 2 * i + 1);
        node.right = buildTree(nums, 2 *i + 2);
        return node;
    }
    public static TreeNode buildTree(Integer[] nums){
        TreeNode root = null;
        if (nums == null || nums.length == 0) {
            return root;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            if (root == null) {
                root = new TreeNode(nums[i]);
                nodeList.addLast(root);
                i++;
                continue;
            }
            TreeNode topEle = nodeList.removeFirst();
            if (nums[i] != null) {
                TreeNode left = new TreeNode(nums[i]);
                topEle.left = left;
                nodeList.addLast(left);
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                TreeNode right = new TreeNode(nums[i]);
                topEle.right = right;
                nodeList.addLast(right);
            }
            i++;
        }
        return root;
    }
}
