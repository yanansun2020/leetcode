package oa.amazon.ftoa;

import java.util.PriorityQueue;

/**
 * method: greedy
 * Time complexity : O(N*log{N})O(NlogN), where NN is the length of the input array. Let's break it down:
 * Step 1) Adding NN elements to the priority queue will be O(N\log{N})O(NlogN).
 * Step 2) We remove two of the smallest elements and then add one element to
 * the priority queue until we are left with one element. Since each such operation will reduce one
 * element from the priority queue, we will perform N-1N−1 such operations. Now, we know that both add
 * and remove operations take O(\log{N})O(logN) in priority queue, therefore, complexity of this step
 * will be O(N\log{N})O(NlogN).
 *
 * Space complexity : O(N)O(N) since we will store NN elements in our priority queue.
 */
public class FulfillmentBuilder {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0; i< sticks.length;i++){
            queue.offer(sticks[i]);
        }
        int cost = 0;
        while(queue.size() > 1){
            int tmp = queue.poll() + queue.poll();
            cost += tmp;
            queue.offer(tmp);
        }
        return cost;
    }
}
