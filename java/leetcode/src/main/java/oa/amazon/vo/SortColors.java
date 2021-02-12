package oa.amazon.vo;

/**
 * low - the last 0
 * hi - the first 1
 * i keep moving in the middle
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1, i = 0;

        while (i <= hi) {
            if      (nums[i] == 0) swap(nums, lo++, i++);
            else if (nums[i] == 2) swap(nums, i, hi--);
            else if (nums[i] == 1) i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
