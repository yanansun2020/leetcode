package recursion;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode res = reverse(pre, head);
        return res;
    }
    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        //head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ReverseList reverseList = new ReverseList();
        ListNode res = reverseList.reverseList(head);

    }
}
