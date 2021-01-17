package oa.amazon.ftoa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PairsofSongsWithTotalDurationsDivisible {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
//        for (int i = 0; i < time.length; i++) {
//            int value = time[i] % 60;
//            map.put(value, map.getOrDefault(value, 0) + 1);
//        }
        for (int i = 0; i < time.length; i++) {
            int target = (60 - time[i]%60) % 60;
            count += map.getOrDefault(target, 0);
            map.put(time[i] % 60, map.getOrDefault(time[i]%60, 0) + 1);
        }
        return count;
    }

    public int getIndex(int v, int[] time){
        int left = 0;
        int right = time.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (time[mid] <= v) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int numPairsDivisibleBy60_brute_force(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) %60 ==0 ) {
                    count++;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[] nums = new int[]{30,20,150,100,40};
        int ans = numPairsDivisibleBy60(nums);
    }
}
