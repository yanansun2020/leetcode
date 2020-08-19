package array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * keep merging the shortest stick
 */
public class MinimumCosttoConnectSticks {
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
    @Test
    public void test(){
        int[] array = {2,4,3};
        int a = connectSticks(array);
        int[] array1 = {1,8,3,5};
        int b = connectSticks(array1);
    }
}
