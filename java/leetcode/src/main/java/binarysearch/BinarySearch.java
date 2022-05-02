package binarysearch;

public class BinarySearch {
    //recursive version
    private int getIndex(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return getIndex(nums, target, mid + 1, right);
        } else {
            return getIndex(nums, target, left, mid - 1);
        }
    }
}
