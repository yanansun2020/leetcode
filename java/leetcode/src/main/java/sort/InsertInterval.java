package sort;

import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> ans = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (isOverlap(intervals[i], newInterval)) {
                while (i < intervals.length && isOverlap(intervals[i], newInterval)){
                    newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
                    i++;
                }
                i--;
                flag = true;
                ans.offer(newInterval);
                continue;
            }
            ans.offer(intervals[i]);
            if (i + 1 < intervals.length && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i+1][0]) {
                flag = true;
                ans.offer(newInterval);
            }
        }
        if (!flag) {
            ans.offer(newInterval);
        }
        int[][] res = new int[ans.size()][2];
        int i = 0;
        while(!ans.isEmpty()){
            res[i++] = ans.poll();
        }
        return res;
    }
    int merge(int[][] intervals, int i, int[] newInterval,  List<int[]>  ans){
        while (i < intervals.length && isOverlap(intervals[i], newInterval)){
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][i], newInterval[1])};
            i++;
        }
        ans.add(newInterval);
        return i;
    }

    private boolean isOverlap(int[] i1, int[] i2){
        return (i2[0] >= i1[0] && i2[0] <= i1[1]) || (i1[0] >= i2[0] && i1[0] <= i2[1]);
    }

    @Test
    public void test(){
//        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] interval = new int[]{4, 8};
//        int[][] ans = insert(intervals, interval);
        int[][] intervals = new int[][]{{2,5},{6,7},{8,9}};
        int[] interval = new int[]{0,1};
        int[][] ans = insert(intervals, interval);
    }
}
