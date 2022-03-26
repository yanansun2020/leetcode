package oa.gg;

/**
 * find target present in s
 */
public class BinarySearch {
    public int findNumber(String s, String t) {
        String[] arr = s.split(",");
        int[] nums = convertToNums(arr);
        int t1 = Integer.parseInt(t);
        return binarySearch(nums, t1);
    }

    private int[] convertToNums(String[] arr) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }

    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }
}
