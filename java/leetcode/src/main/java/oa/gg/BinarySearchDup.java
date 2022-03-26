package oa.gg;

import org.junit.Test;

/**
 * find the first present t in s
 */
public class BinarySearchDup {
    public int findNumber(String s, String t) {
        String[] arr = s.split(",");
        int[] nums = convertToNums(arr);
        int t1 = Integer.parseInt(t);
        return firstPresent(nums, t1);
    }

    private int[] convertToNums(String[] arr) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }

    int firstPresent(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    int lastPresent(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= x)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    @Test
    public void test() {

    }
}
