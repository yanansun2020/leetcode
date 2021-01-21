package oa.amazon.ftoa;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairWithGivenSum {
    public int[] findPair(int[] nums, int target) {
        target -= 30;
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            if (numMap.containsKey(second)) {
                int[] partialRes = new int[]{i, numMap.get(second)};
                if (ans[0] == -1) {
                    ans = partialRes;
                } else {
                    int maxAns = Math.max(nums[ans[0]], nums[ans[1]]);
                    int maxPartialRes = Math.max(nums[partialRes[0]], nums[partialRes[1]]);
                    if (maxPartialRes > maxAns) {
                        ans = partialRes;
                    }
                }
            }
            numMap.put(first, i);
        }
        return ans;
    }


    public static List<Integer> findPair(List<Integer> nums, int target) {
        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = Arrays.asList(-1, -1);
        int largest = 0;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if ((nums.get(i) > largest || complement > largest) && map.containsKey(complement)) {
                result.set(0, map.get(complement));
                result.set(1, i);
                largest = Math.max(nums.get(i), complement);
            }
            map.put(nums.get(i), i);
        }
        return result;
    }


    @Test
    public void test(){
        int[] nums = new int[]{20, 50, 40, 25, 30, 10};
        int[] ans = findPair(nums, 90);
        nums = new int[]{0, 0};
        ans = findPair(nums, 10);
    }
}
