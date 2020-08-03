package list;

import org.junit.Test;

import java.util.PriorityQueue;

public class  MergekSortedLists{
//    priority soution
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (node != null)
                minHeap.add(node);
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode node;
        while (!minHeap.isEmpty()) {
            node = minHeap.remove();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return head.next;
    }
//    directly merge solution
    public ListNode mergeKLists_merge(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int length = lists.length;
        int i = 1;
        ListNode init_list = lists[0];
        while(i < length){
            init_list =merge(init_list,lists[i]);
            i++;
        }
        return init_list;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return head.next;
    }
    @Test
    public void test(){
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node4;
        node4.next = node5;
        node2.next = node6;
        ListNode node11 = new ListNode(1);
        node11.next = node3;
        node3.next = new ListNode(4);
        ListNode[] lists = {node1,node11, node2};
        mergeKLists(lists);
    }
}
