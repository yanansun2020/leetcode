package oa.gg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2)->t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0]);
        int curTime = tasks[0][0];
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            if (curTime > task[0]) {
                tmp.add(i);
            } else {
                res.add(i);
                curTime += task[1];
            }
        }
        Collections.reverse(tmp);
        res.addAll(tmp);
        int[] resArray = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};
        int[] res = getOrder(arr);
    }
}
