package oa.amazon.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        Arrays.sort(intervals, (a, b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[1] < toBeRemoved[0] || cur[0] > toBeRemoved[1]) {
                res.add(Arrays.asList(cur[0], cur[1]));
                continue;
            }
            if (cur[0] < toBeRemoved[0]) {
                Integer[] tmp = new Integer[]{cur[0], toBeRemoved[0]};
                res.add(Arrays.asList(tmp));
            }
            if (cur[1] > toBeRemoved[1]) {
                Integer[] tmp = new Integer[]{toBeRemoved[1], cur[1]};
                res.add(Arrays.asList(tmp));
            }
        }
        return res;
    }
}
