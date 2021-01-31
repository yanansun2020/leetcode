package oa.amazon.vo;

import list.ListNode;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 *
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode();
        ListNode tail= head;
        for (ListNode node : lists) {
            //corner case
            if(node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode topEle = queue.poll();
            tail.next = topEle;
            tail = tail.next;
            //corner case
            if (topEle.next != null) {
                queue.offer(topEle.next);
            }

        }
        return head.next;
    }
}

