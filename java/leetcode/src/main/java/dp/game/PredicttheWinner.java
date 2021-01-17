package dp.game;

import org.junit.Test;

/**
 * dfs all possible values, get the max difference
 * same as stone game
 */
public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return dfs(0, n -1, nums, memo) >= 0;
    }

    int dfs(int l, int r, int[] nums, Integer[][] memo){
        if (l == r) {
            memo[l][r] = nums[l];
            return nums[l];
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        int leftValue = nums [l] - dfs(l + 1, r, nums, memo);
        int rightMax = nums[r] - dfs(l, r - 1, nums, memo);
        memo[l][r] = Math.max(leftValue, rightMax);
        return memo[l][r];
    }
    @Test
    public void test(){
        int[] nums = new int[]{1, 5,2};
        boolean res = PredictTheWinner(nums);
    }
}
