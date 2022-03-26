package oa.gg;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBstToBalancedBST {
    public TreeNode getBalancedBST(TreeNode root) {
        List<TreeNode> inOrderRes = new ArrayList<>();
        getInOrderTraverse(root, inOrderRes);
        TreeNode res = buildBalance(inOrderRes, 0, inOrderRes.size() - 1);
        return res;
    }

    private TreeNode buildBalance(List<TreeNode> inOrderRes, int left, int right) {
        if (left > right) {
            return null ;
        }
        int middle = left + (right - left) / 2;
        TreeNode  node = inOrderRes.get(middle);
        node.left = buildBalance(inOrderRes, left, right - 1);
        node.right = buildBalance(inOrderRes, left + 1, right);
        return node;
    }

    private void getInOrderTraverse(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }
        getInOrderTraverse(node.left, res);
        res.add(node);
        getInOrderTraverse(node.right, res);
    }
}
