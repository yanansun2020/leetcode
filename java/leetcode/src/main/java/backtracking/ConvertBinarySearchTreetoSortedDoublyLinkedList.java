package backtracking;

import tree.Node;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
//    Node pre = null;
//    Node head = null;
//    public Node treeToDoublyList(Node root) {
//        getList(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//
//    private void getList(Node cur) {
//        if (cur == null){
//            return;
//        }
//        System.out.println(cur.val);
//        getList(cur.left);
//        if (head == null) {
//            head = cur;
//        }
//
//        if (pre != null) {
//            pre.right = cur;
//            cur.left = pre;
//        }
//        pre = cur;
//        getList(cur.right);
//    }


    private void getList(Node cur, Node head, Node pre) {
        if (cur == null){
            return;
        }
        System.out.println(cur.val);
        getList(cur.left, head, pre);
        if (head == null || head.val == 0) {
            head = cur;
        }

        if (pre != null && pre.val != 0) {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        getList(cur.right, head, pre);
    }

    public static void main(String[] args) {
        Node node = new Node(2, new Node(1), new Node(3));
        ConvertBinarySearchTreetoSortedDoublyLinkedList convert = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
//        //Node rs = convert.treeToDoublyList(node);
//        Node h = new Node();
//        Node p = new Node();
//        convert.getList(node, h, p);
//        System.out.print(1);

        convert.changeNodeValue(node);
        System.out.print(1);

    }

    private void changeNodeValue(Node n) {
        n.val = 1;
        n.left = new Node(9);
        n = new Node(9);
    }
}
