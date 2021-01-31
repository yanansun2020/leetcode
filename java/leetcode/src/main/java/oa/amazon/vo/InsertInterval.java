package oa.amazon.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        MergeInterval merged = null;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (overlap(intervals[i], newInterval)) {
                merged = getMergeInterval(i, intervals, newInterval);
                break;
            }
            list.add(intervals[i]);
        }
        if (merged == null) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][2]);
        }
        list.add(merged.mergedInterval);
        for (int i = merged.index; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        return list.toArray(new int[list.size()][2]);
    }

    private boolean overlap(int[] interval1, int[] interval2){
        if (interval2[0] <= interval1[1]) {
            return true;
        }
        return false;
    }

    private MergeInterval getMergeInterval(int index, int[][] intervals, int[] newInterval) {
        int i = index;
        for (; i < intervals.length; i++) {
            if (overlap(intervals[i], newInterval)) {
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            }
        }
        MergeInterval merged = new MergeInterval();
        merged.mergedInterval = newInterval;
        merged.index = i;
        return merged;
    }
}

class MergeInterval{
    int[] mergedInterval;
    int index;
}
