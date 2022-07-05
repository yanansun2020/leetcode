package algorithm.treemap;

import org.junit.Test;

import java.util.TreeSet;

public class LongestContinuous1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeSet<Integer> set = new TreeSet<>((a, b)-> nums[a] == nums[b]? a - b : nums[a] - nums[b]);
        int l = 0;
        int res = 1;
        set.add(0);
        for (int r = 1; r < nums.length; r++) {

            while (Math.abs(nums[r]- nums[set.first()]) > limit) {
                set.remove(l);
                l++;
            }
            set.add(r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


 @Test
    public void test() {
        int[] a = new int[]{1,2,3};
        longestSubarray(a, 1);
    }
}
