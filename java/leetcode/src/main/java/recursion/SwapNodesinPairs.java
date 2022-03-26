package recursion;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = swapPairs(next.next);
        next.next = cur;
        return next;
    }
}
