package array;

import org.junit.Test;

public class InsertintoaSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        Node node = head;
        if(node == null){
            Node ans = new Node(insertVal);
            ans.next = ans;
            return ans;
        }
        while(node.next.val != head.val && node.val > insertVal){
            node = node.next;
        }
        Node tmp = node.next;
        Node newNode = new Node(insertVal);
        node.next = newNode;
        newNode.next = tmp;
        return head;
    }
    @Test
    public void test(){
        Node head = new Node(1);
        Node tail = new Node(2);
        head.next =tail;
        tail.next = head;
        insert(head, 0);
    }
}


