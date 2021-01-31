package oa.amazon.vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        List<int[]> res = new LinkedList<>();
        int[] cur = intervals[0];
        for(int[] interval : intervals) {
            if (interval[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                res.add(cur);
                cur = interval;
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }

    public int[][] merge_1(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>( (o1, o2)->o2[1] - o1[1]);
        for (int[] interval : intervals) {
            if(queue.isEmpty()) {
                queue.offer(interval);
                continue;
            }
            int[] topEle = queue.peek();
            if (topEle[1] >= interval[0]) {
                topEle[1] = Math.max(topEle[1],interval[1]);
            } else {
                queue.offer(interval);
            }
        }

        int[][] res = new int[queue.size()][2];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
    @Test
    public void test() {
        int[] aaa = new int[]{43, 1, 9};
        Arrays.sort(aaa);
    }
}
