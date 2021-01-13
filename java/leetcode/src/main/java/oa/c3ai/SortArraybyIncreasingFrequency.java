package oa.c3ai;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArraybyIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = getFreq(nums);
        int[][] tmp = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tmp[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        Arrays.sort(tmp, (a, b)->a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int[] ans = new int[nums.length];
        for (int[] tmp1 : tmp) {
            for (int j = 0; j < tmp1[1]; j++) {
                ans[i++] = tmp1[0];
            }
        }
        return ans;
    }
    private Map<Integer, Integer> getFreq(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
    @Test
    public void test(){
        int[] nums = new int[]{1,1,2,2,2,3};
        int[] ans = frequencySort(nums);
    }
}
