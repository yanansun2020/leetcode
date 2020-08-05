package list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode();
        ListNode pre = result;
        while(node1 != null || node2 != null){
            int node_value = carry;
            if(node1 != null){
                node_value += node1.val;
            }
            if(node2 != null){
                node_value += node2.val;
            }
            if (node_value >=10){
                carry = 1;
                node_value = node_value -10;
            }else{
                carry = 0;
            }
            pre.next = new ListNode(node_value);
            pre = pre.next;
            if (node1 != null){
                node1 = node1.next;
            }
            if (node2 != null){
                node2 = node2.next;
            }
        }
        if (carry == 1){
            pre.next = new ListNode(1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(1);
    }
}