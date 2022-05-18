package bst;

import tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> pre;
    Stack<TreeNode> next;
    TreeNode p;
    public BinarySearchTreeIterator(TreeNode root) {
        pre = new Stack<>();
        next = new Stack<>();
        p = null;
        while (root != null) {
            root.val *= -1;
            pre.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !pre.isEmpty();
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        if (p != null) {
            TreeNode node = p.right;
            while (node != null && node.val > 0) {
                node.val *= -1;
                next.push(node);
                node = node.left;
            }
            pre.push(p);
        }
        p = next.pop();
        return Math.abs(p.val);
    }

    public boolean hasPrev() {
        return !pre.isEmpty();
    }

    public int prev() {
        if (!hasPrev()) {
            return -1;
        }

        next.push(p);
        p = pre.pop();
        return Math.abs(p.val);
    }
}
