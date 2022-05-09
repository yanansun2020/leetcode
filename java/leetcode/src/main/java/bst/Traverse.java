package bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Traverse {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        Traverse traverse = new Traverse();
        List<Integer> res = new ArrayList<>();
        traverse.reverseTraverse(node, res);
        for (int nums : res) {
            System.out.print(nums + " ");
        }
    }
    private void reverseTraverse(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        reverseTraverse(node.right, res);
        res.add(node.val);
        reverseTraverse(node.left, res);
    }
}
