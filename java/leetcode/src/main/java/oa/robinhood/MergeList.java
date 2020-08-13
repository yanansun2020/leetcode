package oa.robinhood;

import list.ListNode;

public class MergeList {
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        } else if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2);
            return  l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3));
        ListNode l2 = new ListNode(2, new ListNode(5));
        MergeList test = new MergeList();
        ListNode result = test.merge(l1, l2);
        System.out.println(result);
    }
}
