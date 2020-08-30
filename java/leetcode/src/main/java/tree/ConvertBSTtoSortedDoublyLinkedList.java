package tree;

import org.junit.Test;

public class ConvertBSTtoSortedDoublyLinkedList {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    public void helper(Node node) {
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
        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        treeToDoublyList(node);
    }
}

