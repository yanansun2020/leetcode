package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * follow up question: how to add and merge them for a large stream of intervals???
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->o1[0]-o2[0]);
        LinkedList<int[]> mergedList = new LinkedList<>();
        for (int[] interval : intervals) {
            if (mergedList.isEmpty()) {
                mergedList.add(interval);
            } else {
                int[] topEle = mergedList.getFirst();
                //not overlap
                if (interval[0] > topEle[1]) {
                    mergedList.addFirst(interval);
                    continue;
                }
                if (interval[0] >= topEle[0] && interval[1] > topEle[1]) {
                    mergedList.removeFirst();
                    mergedList.addFirst(new int[]{topEle[0], interval[1]});
                }
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
    @Test
    public void test(){
        int[][] intervals = new int[][]{{1,3}, {1, 4},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        intervals = new int[][]{{1, 4}, {4, 5}};
        ans = merge(intervals);
    }
}
