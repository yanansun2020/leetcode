package array;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(final int[] nums, final int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        final int target = sum / k;
        Arrays.sort(nums);
        final boolean[] visited = new boolean[nums.length];
        return dfs(0, target, 0, k, nums, visited);
    }

    public boolean dfs(final int start, final int target, final int curSum, final int k, final int[] nums,
            final boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (target == curSum) {
            return dfs(0, target, 0, k - 1, nums, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] + curSum > target) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            final boolean result = dfs(i + 1, target, nums[i] + curSum, k, nums, visited);
            visited[i] = false;
            if (result) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        PartitiontoKEqualSumSubsets test = new PartitiontoKEqualSumSubsets();
        int[] array1 = { 1, 2, 2,3,3,4,5 };
        System.out.println(test.canPartitionKSubsets(array1, 4));
        final int[] array = { 1, 2, 3 };
        System.out.println(test.canPartitionKSubsets(array, 2));
    }
}