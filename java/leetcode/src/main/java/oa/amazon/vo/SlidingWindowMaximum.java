package oa.amazon.vo;

import java.util.LinkedList;

/**
 *
 *  You want to ensure the deque window only has decreasing elements.
 *  That way, the leftmost element is always the largest.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Ele> deq = new LinkedList<Ele>();
        init(nums, k, deq);
        res[0] = deq.getFirst().ele;
        for (int i = k; i < nums.length; i++) {
            Ele cur = new Ele(nums[i], i);
            clean_deq(deq, cur, k);
            deq.offer(cur);
            res[i - k + 1] = deq.getFirst().ele;
        }
        return res;
    }

    private void init(int[] nums, int k, LinkedList<Ele> deq){
//        Node max_node = get_max(nums, k);
        for (int i = 0; i < k; i++) {
            Ele cur = new Ele(nums[i], i);
            clean_deq(deq, cur, k);
            deq.offer(cur);

        }
    }
    private Ele get_max(int[] nums, int k){
        Ele maxNode = new Ele(nums[0], 0);
        for (int i = 0; i < k; i++) {
            if (maxNode.ele < nums[i]) {
                maxNode = new Ele(nums[i], i);
            }
        }
        return maxNode;
    }
    private void clean_deq(LinkedList<Ele> deq, Ele curNode, int k){
        if (!deq.isEmpty() && (curNode.index - deq.getFirst().index == k)) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && deq.getLast().ele < curNode.ele) {
            deq.removeLast();
        }
    }
}

class Ele{
    int ele;
    int index;
    Ele(){}
    Ele(int ele, int index){
        this.ele = ele;
        this.index = index;
    }
}
