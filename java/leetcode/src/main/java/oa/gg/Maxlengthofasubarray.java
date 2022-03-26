package oa.gg;

import java.util.HashMap;
import java.util.Map;

/**
 *
 given an array, return the max length of a subarray where the sum of this subarray equals 0. 挺好的一题
 example: [-1,1,0,2,-1,3] return 2.   -1 + 1 = 0
 example: [-2,2,3,-3,1,-1,6] return 6.    -2 + 2 + 3 + -3 + 1 + -1 = 0
 example: [0,0,0,0] return 4
 example: [0, 1, 2] return 1
 */
public class Maxlengthofasubarray {
    int maxLengthWithSumZero(int[] arr) {
        int length = arr.length;
        int[] preSum = new int[length];
        preSum[0] = arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        map.put(arr[0], 0);
        int maxLength = 0;
        for (int i = 1; i < length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
            if (map.get(preSum[i]) == null) {
                map.put(preSum[i], i);
            } else {
                maxLength = Math.max(maxLength, i - map.get(preSum[i]));
            }
        }
        return maxLength;
    }
}
