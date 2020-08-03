package list;

import org.junit.Test;

public class  MergekSortedLists{
    public ListNode mergeKLists(ListNode[] lists) {
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
    public ListNode merge(ListNode node_i, ListNode node_j){
        ListNode pre = new ListNode();
        ListNode result = pre;
        while(node_i != null && node_j != null){
            if(node_i.val == node_j.val){
                pre.next = new ListNode(node_i.val);
                pre.next.next = new ListNode(node_i.val);
                node_i = node_i.next;
                node_j = node_j.next;
                pre = pre.next;
            }else if(node_i.val > node_j.val){
                pre.next = new ListNode(node_j.val);
                node_j = node_j.next;
            }else{
                pre.next = new ListNode(node_i.val);
                node_i = node_i.next;
            }
            pre = pre.next;
        }
        if (node_i != null){
            pre.next = node_i;
        }
        if (node_j != null){
            pre.next = node_j;
        }
        return result.next;
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
