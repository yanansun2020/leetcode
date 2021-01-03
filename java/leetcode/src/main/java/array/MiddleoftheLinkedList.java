package array;

import list.ListNode;

/**
 * fast slow pointer, fast pointer goes two steps/iterate
 * slow pointer goes one step/iterate
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
