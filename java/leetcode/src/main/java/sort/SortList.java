package sort;

import list.ListNode;
import org.junit.Test;

public class SortList {
    /**
     * merge sort linkedlist
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode();
        ListNode cur = head;
        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null){
            cur.next = left;
        }
        if (right != null){
            cur.next = right;
        }
        return head.next;
    }

    private ListNode findMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    /**
     * insert sort linkedlist
     * @param head
     * @return
     */
    public ListNode sortList_TLE(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode();
        ans.next = new ListNode(head.val);
        for (ListNode j = head.next; j != null; j = j.next) {
            ListNode pre = ans;
            ListNode i = ans.next;
            boolean flag = false;
            for (; i != null; i = i.next) {
                if (i.val > j.val) {
                    flag = true;
                    insertNode(pre, new ListNode(j.val));
                    break;
                }
                pre = i;
            }
            if (!flag) {
                insertNode(pre, new ListNode(j.val));
            }
        }
        return ans.next;
    }

    private void insertNode(ListNode pre, ListNode node){
        ListNode next = pre.next;
        pre.next = node;
        node.next = next;
    }

    private void removeNode(ListNode pre, ListNode node){
        ListNode next = node.next;
        pre.next = next;
        node.next = null;
    }
    @Test
    public void test(){
        int[] nums = new int[]{4,2,1,3};
        ListNode head = ListNode.buildNode(nums);
        ListNode ans = sortList(head);
        nums = new int[]{-1,5,3,4,0};
        head = ListNode.buildNode(nums);
        ans = sortList(head);
    }
}
