package oa.amazon.vo;

import java.util.HashMap;

public class CopyListwithRandomPointer {
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        Node newHead = new Node(head.val);
        Node newNode = newHead;
        Node cur = head;

        while (cur != null) {
            newNode.next = getNewNode(cur.next);
            newNode.random = getNewNode(cur.random);
            cur = cur.next;
            newNode = newNode.next;
        }
        return newHead;
    }
    private Node getNewNode(Node old) {
        if (old == null) {
            return null;
        }
        if (map.containsKey(old)) {
            return map.get(old);
        }
        Node node = new Node(old.val);
        map.put(old, node);
        return map.get(old);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
