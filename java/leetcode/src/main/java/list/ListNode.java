package list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode buildNode(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i= 1; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
}
