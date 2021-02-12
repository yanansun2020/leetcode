package oa.amazon.vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else if (o1[1] > o2[1]) {
                        return 1;
                    } else  {
                        return 0;
                    }
                }
                if (o1[0] > o2[0]) {
                    return 1;
                }
                return -1;
            }
        });
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b)->b[1].compareTo(a[1]));
        for (int[] cur : points) {
            if (!queue.isEmpty() && cur[0] <= queue.peek()[1]) {
                Integer[] top = queue.poll();
                int min = Math.max(cur[0], top[0]);
                int max = Math.min(cur[1], top[1]);
                queue.offer(new Integer[]{min, max});
            } else {
                queue.offer(new Integer[]{cur[0], cur[1]});
            }
        }
        return queue.size();
    }
    @Test
    public void test() {
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int ans = findMinArrowShots(points);
    }
}
