package oa.amazon.ftoa;

import org.junit.Test;

public class PartitionArrayforMaximumSum {
    //dp[i] 截止到i能好获得的最大值
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int maxValue = arr[0];
        for (int i = 0; i < k; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            dp[i] = maxValue * (i + 1);
        }
        for (int i = k; i < arr.length; i++) {
            int curMax = arr[i];
            //try all possibilities
            for (int j = 1; j <= k; j++) {
                curMax = Math.max(curMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j]  + curMax * j);
            }
        }
        return dp[arr.length - 1];
    }

    @Test
    public void test(){

    }

}
