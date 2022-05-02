package algorithm.sort;
//applciation of merge sort
public class InversionCount {
    private int getCount(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int left, int right) {
        int inverseCount = 0;
        if (left < right) {
            int mid = (right - left)/2  + left;
            inverseCount += mergeSort(nums, left, mid);
            inverseCount += mergeSort(nums, mid + 1, right);
            inverseCount += merge(nums, left, mid, right);
        }
        return inverseCount;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int inverseCount = 0;
        while (i <= mid && j <= right) {
            if (nums[j] < nums[i]) {
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
        return inverseCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,4,1};
        InversionCount inversionCount = new InversionCount();
        arr = new int[]{1,3,2,3,1};
        int count = inversionCount.getCount(arr);
        System.out.println(count);
    }
}
