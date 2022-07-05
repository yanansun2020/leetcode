package oa.ms;

public class ArithmeticSubarray {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i-2]) {
                res[i] = res[i - 1] + 1;
            }
        }
        int result = 0;
        for (int r : res) {
            result += r;
        }
        return result;
    }


    public int numberOfArithmeticSlices1(int[] nums) {
        int size = nums.length, ret = 0;
        if (size >= 3) {
            for (int i = 0; i < size - 2;) {
                int diff1 = nums[i + 1] - nums[i], diff2 = nums[i + 2] - nums[i + 1];
                if (diff1 == diff2) {
                    int end = i + 2;
                    while (end < size && nums[end] - nums[end - 1] == diff1) {
                        end++;
                    }
                    // length of the consecutive subarray that has same adjacent diff.
                    int len = end - i;
                    // may produce such amount amount of `arithmetic slices`.
                    ret += (len - 1) * (len - 2) / 2;

                    // forwarding to the sequence's end + 1
                    i = end - 2;
                } else {
                    i++;
                }
            }
        }

        return ret;
    }
}
