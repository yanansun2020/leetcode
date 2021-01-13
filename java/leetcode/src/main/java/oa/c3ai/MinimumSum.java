package oa.c3ai;

import java.util.PriorityQueue;

public class MinimumSum {
    public int min(int[] arr, int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(new int[]{arr[i], i});
        }
        while (k > 0) {
            int[] ele = queue.poll();
            int value = (int)Math.ceil(ele[0]/2);
            arr[ele[1]] = value;
            k--;
        }
        int minSum = 0;
        for (int a : arr) {
            minSum += a;
        }
        return minSum;
    }
}
