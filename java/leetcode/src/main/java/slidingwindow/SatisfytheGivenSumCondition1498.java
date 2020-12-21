package slidingwindow;

import org.junit.Test;

import java.util.Arrays;

/**
 * having problem in converting data type, but python solved
 * solution: permutation
 *
 */
public class SatisfytheGivenSumCondition1498 {
    public int numSubseq(int[] nums, int target) {
        long count = 0;
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            }else {
                int window_length = right - left;
                count +=((Math.pow(2, window_length)) %(1e9+ 7));
                left++;
            }
        }
        return (int)(count%(1e9+ 7));
    }

//    private int find_right_most_index(int[] nums, int target){
//        int right = 0;
//        while (right <nums.length && nums[0] + nums[right] <= target){
//            right++;
//        }
//        return right;
//    }

    @Test
    public void test(){
        int[] nums = new int[]{3,5,6,7};
        int res = numSubseq(nums, 9);
        nums = new int[]{3,3,6,8};
        res = numSubseq(nums, 10);
        nums = new int[]{2,3,3,4,6,7};
        res = numSubseq(nums, 12);
        nums = new int[]{5,2,4,1,7,6,8};
        res = numSubseq(nums, 16);
        nums = new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        res = numSubseq(nums, 22);
    }
}
