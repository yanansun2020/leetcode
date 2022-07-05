package oa.ms;
//lc 33
public class SearchEleinSortRoatedArray {
    private int getIndex(int[] nums, int t, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = (r - l)/2 + l;
        if (nums[m] == t) {
            return m;
        }
        if (nums[m] >= nums[l]) {
            if (t < nums[m] && t >= nums[l]) {
                return getIndex(nums, t, l, m - 1);
            } else {
                return getIndex(nums, t, m + 1, r);
            }
        } else {
            if (t > nums[m] && t <= nums[r]) {
                return getIndex(nums, t, m + 1, r);
            } else {
                return getIndex(nums, t, l, m - 1);
            }
        }
    }
}
