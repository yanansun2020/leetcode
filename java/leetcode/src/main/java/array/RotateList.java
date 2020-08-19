package array;

import list.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int nodeNumber = 0;
        ListNode node = head;
        while(node != null){
            nodeNumber++;
            node =node.next;
        }
        node = head;
        int count = 0;
        ListNode reversedNode = null;
        while(node!= null){
            count++;
            if (count == nodeNumber -k){
                reversedNode =reverse(node.next);
                node.next = null;
            }
            node = node.next;
        }
        ListNode ans = reversedNode;
        while(reversedNode !=null){
            if (reversedNode.next == null){
                reversedNode.next = head;
            }
            reversedNode = reversedNode.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next = node.next;
        while(node != null){
            node.next = pre;
            pre = node;
            node = next;
            next = node.next;
        }
        return pre;
    }
}
