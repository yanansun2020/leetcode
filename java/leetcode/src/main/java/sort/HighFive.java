package sort;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * map + minheap
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items){
            PriorityQueue<Integer> queue = map.getOrDefault(item[0], new PriorityQueue<>((o1, o2) -> o1.compareTo(o2)));
            if (queue.size() >= 5){
                if(queue.peek() < item[1]){
                    queue.poll();
                    queue.offer(item[1]);
                }
            } else{
                queue.offer(item[1]);
            }
            map.put(item[0], queue);
        }
        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int stuId = entry.getKey();
            int avgScore = getAvgScore(entry.getValue());
            ans[i++] = new int[]{stuId, avgScore};
        }
        return ans;
    }
    private int getAvgScore(PriorityQueue<Integer> queue){
        int sumScore = 0;
        while (!queue.isEmpty()){
            sumScore += queue.poll();
        }
        return sumScore/5;
    }
    @Test
    public void test(){
        int[][] items = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] ans = highFive(items);
    }
}
