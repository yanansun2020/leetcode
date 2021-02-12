package oa.amazon.vo;

import org.junit.Test;
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }



    public int maxSubArray_1(int[] nums) {
        int max_count = nums[0];
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for(int i =1; i < nums.length; i++){
            array[i] = Math.max(nums[i], nums[i] +array[i-1]);
            max_count = Math.max(max_count, array[i]);

        }
        return max_count;
    }

    @Test
    public void test(){
        int[] arr = new int[]{-2, 1, -3, 4};
        int res = maxSubArray(arr);
    }
}
