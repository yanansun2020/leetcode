package array;

import org.junit.Test;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int rotateIndex = find_rotate_index(nums);
        if (target > nums[0]) {
            return binarySearch(nums, target, 0, rotateIndex);
        }
        return binarySearch(nums, target, rotateIndex + 1, nums.length - 1);
    }
    private int find_rotate_index(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid + 1]){
                return mid;
            } else {
                if(nums[mid] > nums[0]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    private int binarySearch(int[] nums, int target, int startIndex, int endIndex){
        int left = startIndex;
        int right = endIndex;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private int upper_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
    private int lower_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid]  >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    @Test
    public void test(){
        int[] nums = new int[]{2,3,4,5,6,7,1,2};
        int index = find_rotate_index(nums);
        nums = new int[]{8, 1,2,3,4};
        index = find_rotate_index(nums);
        nums = new int[]{3,4,1,2};
        index = find_rotate_index(nums);
        nums = new int[]{1,1,1,2,2,2,4};
        index = lower_bound(nums, 5);
        index = upper_bound(nums, 5);
    }
}
