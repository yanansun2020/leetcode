package array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * union find
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numsSet = new HashSet<>();
        for (int i =0; i<nums.length; i++) {
          numsSet.add(nums[i]);
        }
        int globalMaxxLength = 1;
        for (int i =0; i < nums.length; i++) {
            int maxLength = 1;
            int cur = nums[i];
            if (numsSet.contains(cur + 1) && !numsSet.contains(cur - 1)){
                while (numsSet.contains(++cur)){
                    maxLength++;
                }
                globalMaxxLength = Math.max(globalMaxxLength, maxLength);
            }
        }
        return globalMaxxLength;
    }

    @Test
    public void test(){
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int maxLength = longestConsecutive(nums);
        System.out.print(maxLength);
    }
}
