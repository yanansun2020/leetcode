package slidingwindow;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * similar to monotone queue
 * keep the elements in the queue with decrease order
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Node> deq = new ArrayDeque<Node>();
        init(nums, k, deq);
        res[0] = deq.getFirst().ele;
        for (int i = k; i < nums.length; i++) {
            Node cur = new Node(nums[i], i);
            clean_deq(deq, cur, k);
            deq.offer(cur);
            res[i - k + 1] = deq.getFirst().ele;
        }
        return res;
    }

    private void init(int[] nums, int k, ArrayDeque<Node> deq){
//        Node max_node = get_max(nums, k);
        for (int i = 0; i < k; i++) {
            Node cur = new Node(nums[i], i);
            clean_deq(deq, cur, k);
            deq.offer(cur);

        }
    }
    private Node get_max(int[] nums, int k){
        Node maxNode = new Node(nums[0], 0);
        for (int i = 0; i < k; i++) {
            if (maxNode.ele < nums[i]) {
                maxNode = new Node(nums[i], i);
            }
        }
        return maxNode;
    }
    private void clean_deq(ArrayDeque<Node> deq, Node curNode, int k){
        if (!deq.isEmpty() && (curNode.index - deq.getFirst().index == k)) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && deq.getLast().ele < curNode.ele) {
            deq.removeLast();
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] res =maxSlidingWindow(nums, 3);
        nums = new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        res =maxSlidingWindow(nums, 7);
        System.out.println();
    }
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>((o1, o2) -> (o2.ele - o1.ele));
        Map<Integer, Node> nodeMap = new HashMap<>();
        init_1(nums, k, nodeQueue, nodeMap);
        res[0] = nodeQueue.peek().ele;
        for (int i = k; i < nums.length; i++){
            Node nodeToRemove = nodeMap.get(i - k);
            nodeQueue.remove(nodeToRemove);
            Node nodeToAdd = new Node(nums[i], i);
            nodeMap.put(i, nodeToAdd);
            nodeQueue.add(nodeToAdd);
            res[i - k + 1] = nodeQueue.peek().ele;
        }
        return res;
    }

    private void init_1(int[] nums, int k, PriorityQueue<Node> nodeQueue, Map<Integer, Node> nodeMap){
        for (int i = 0; i < k; i++) {
            Node node = new Node(nums[i], i);
            nodeQueue.offer(node);
            nodeMap.put(i, node);
        }
    }

}

class Node{
    int ele;
    int index;
    Node(){}
    Node(int ele, int index){
        this.ele = ele;
        this.index = index;
    }
}

