package oa.amazon.vo;

import java.util.Arrays;

public class NonOverlapInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int end = Integer.MIN_VALUE;
        int count  = 0;
        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                end = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
