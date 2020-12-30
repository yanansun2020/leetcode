package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * split into three part:
 * left + leaves + right
 */
public class BoundaryofBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        ans.addAll(getLeftMostNodes(root.left));
        List<Integer> leaves = new ArrayList<>();
        if (!isLeaf(root)) {
            getLeaves(root, leaves);
        }
        ans.addAll(leaves);
        ans.addAll(getRightMostNodes(root.right));
        return ans;
    }


    public List<Integer> getLeftMostNodes(TreeNode node){
        List<Integer> leftNodes = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                leftNodes.add(node.val);
            }
            if (node.left != null){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return leftNodes;
    }

    public void getLeaves(TreeNode node, List<Integer> leaves){
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            leaves.add(node.val);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
    public List<Integer> getRightMostNodes(TreeNode node){
        List<Integer> rightNodes = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                rightNodes.add(node.val);
            }
            if (node.right != null){
                node = node.right;
            } else {
                node = node.left;
            }
        }
        Collections.reverse(rightNodes);
        return rightNodes;
    }


    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{1};
        TreeNode root = TreeNode.buildTree(nums);
        List<Integer> ans = boundaryOfBinaryTree(root);
    }
}
