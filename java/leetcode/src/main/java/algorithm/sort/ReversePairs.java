package algorithm.sort;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        int inverseCount = 0;
        if (left < right) {
            int mid = (right - left)/2  + left;
            inverseCount += mergeSort(nums, left, mid);
            inverseCount += mergeSort(nums, mid + 1, right);
            for (int i = left, j = mid+1; i <= mid && j <= right;){
                if (nums[i] > (long) nums[j] * 2){
                    inverseCount += mid - i + 1;
                    j++;
                }
                else i++;
            }
            merge(nums, left, mid, right);
        }
        return inverseCount;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int inverseCount = 0;
        while (i <= mid && j <= right) {
            if (nums[j] < nums[i]) {
                if (nums[i] > 2 * nums[j]) {
                    inverseCount += mid - i + 1;
                }
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while(j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = tmp[k];
        }
    }
}
