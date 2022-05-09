package bst;

import tree.Node;
import tree.TreeNode;

public class BstToList426 {

    Node pre = null;
    Node head = null;


    public static void main(String[] args) {
        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        BstToList426 bst = new BstToList426();
        bst.treeToDoublyList(node);
    }

    public Node treeToDoublyList(Node root) {
        getList(root);
        return head;
    }

    private void getList(Node node) {
        if(node == null) {
            return;
        }
        getList(node.left);
        //System.out.println(node.val);
        if (head == null) {
            head = node;
        }
        if(pre == null) {
            pre = node;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        getList(node.right);
    }
}
