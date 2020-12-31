package tree.bst;

import org.junit.Test;
import tree.TreeNode;

public class ConvertBSTtoSortedDoublyLinkedList {
    TreeNode first = null;
    TreeNode last = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    public void helper(TreeNode node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }
    @Test
    public void test(){
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        treeToDoublyList(node);
    }
}

