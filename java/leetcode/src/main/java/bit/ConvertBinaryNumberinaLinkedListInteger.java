package bit;

import list.ListNode;

public class ConvertBinaryNumberinaLinkedListInteger {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int ans = head.val == 1? 1 : 0;
        ListNode node = head.next;
        while (node != null ) {
            ans <<= 1;
            if (node.val == 1) {
                ans += 1;
            }
            node = node.next;
        }
        return ans;
    }
}
