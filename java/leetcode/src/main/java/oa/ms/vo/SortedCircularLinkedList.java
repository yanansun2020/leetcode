package oa.ms.vo;

public class SortedCircularLinkedList {
    CircularList list = new CircularList();

}

class CircularList{
    ListNode head;
    ListNode tail;
    CircularList() {
       head = new ListNode(null);
       tail = new ListNode(null);
       head.next = tail;
       tail.next = head;
    }

    public void addNode(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        ListNode pre = cur;
        while(cur.next.val != null && node.val >= cur.next.val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur.next;
        return;
    }

    public boolean delete(int val) {
        ListNode cur = this.head;
        ListNode pre = cur;
        while (cur.next.val != null && cur.next.val < val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur.val != null && cur.val == val) {
            pre.next = cur.next;
            return true;
        }
        return false;
    }

    public void print() {
        ListNode cur = head;
        while (cur.next.val != null) {
            System.out.println(cur.next.val);
            cur = cur.next;
        }
    }

}

class ListNode{
    Integer val;
    ListNode next;
    ListNode(Integer val) {
        this.val = val;
    }
}
