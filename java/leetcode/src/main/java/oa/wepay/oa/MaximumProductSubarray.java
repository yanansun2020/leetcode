package oa.wepay.oa;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] maxValue = new int[nums.length];
        int[] minValue = new int[nums.length];
        maxValue[0] = nums[0];
        minValue[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp1 = maxValue[i-1] * nums[i];
            int tmp2 = minValue[i-1] * nums[i];
            if (tmp1 > tmp2) {
                maxValue[i] = Math.max(tmp1, nums[i]);
                minValue[i] = Math.min(tmp2, nums[i]);

            } else {
                maxValue[i] = Math.max(tmp2, nums[i]);
                minValue[i] = Math.min(tmp1, nums[i]);
            }
            res = Math.max(res, maxValue[i]);
        }
        return res;
    }
}
