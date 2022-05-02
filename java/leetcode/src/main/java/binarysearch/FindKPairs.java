package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindKPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int nums_i = nums[i];
            int nums_j = nums_i - k;
            if (map.containsKey(nums_j)) {
                pairs++;
            }
            map.put(nums_i, 1);
            while(i - 1 >= 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3,1,4,1,5};
//        FindKPairs findKPairs = new FindKPairs();
//        int res = findKPairs.findPairs(arr, 2);

        StringBuilder sb = new StringBuilder();
        sb.append("a").append(":").append("172");
        System.out.println(sb.toString());
    }
}
