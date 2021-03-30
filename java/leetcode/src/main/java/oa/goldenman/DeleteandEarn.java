package oa.goldenman;

import org.junit.Test;

/**
 * same as house rob
 * each house, you can choose rob or not
 * if rob, profit = rob(k) + dp[k-2]
 * otherwise, profit = dp[k-1]
 */
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num: nums) {
            count[num]++;
        }
        int[] dp = new int[10001];
        int res = 0;
        for (int k = 1; k <= 10000; ++k){
            int delteKProfit = k * count[k] + dp[k - 2 <0? 0 : k - 2];
            int notDeleteProfit = dp[k - 1];
            dp[k] = Math.max(delteKProfit, notDeleteProfit);
            res = Math.max(res, dp[k]);
        }
        return res;
    }

    @Test
    public void test () {
        int[] nums = new int[]{3, 4, 2};
        int ans = deleteAndEarn(nums);
    }
}
