package bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//stack + reverse order of BST
public class KthClosestNodesToTarget {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        getSortedPath(root, s1, false, target);
        getSortedPath(root, s2, true, target);
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            if (s1.isEmpty())
                res.add(s2.pop().val);
            else if (s2.isEmpty())
                res.add(s1.pop().val);
            else if (Math.abs(s1.peek().val - target) < Math.abs(s2.peek().val - target))
                res.add(s1.pop().val);
            else
                res.add(s2.pop().val);
        }
        return res;
    }
    //reverse = true: reversed order; reverse=false: sorted order
    private void getSortedPath(TreeNode node, Stack<TreeNode> res, boolean reverse, double target) {
        if (node == null) {
            return;
        }
        if (!reverse) {
            getSortedPath(node.left, res, reverse, target);
        } else {
            getSortedPath(node.right, res, reverse, target);
        }
        if (!reverse && node.val > target) {
            return;
        }
        if (reverse && node.val <= target) {
            return;
        }
        res.push(node);
        if (!reverse) {
            getSortedPath(node.right, res, reverse, target);
        } else {
            getSortedPath(node.left, res, reverse, target);
        }
    }
}
