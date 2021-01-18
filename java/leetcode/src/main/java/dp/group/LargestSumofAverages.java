package dp.group;

import org.junit.Test;

/**
 * dp[i] = put the first i element into k group, the avg value is stored on it
 */
public class LargestSumofAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] preSum = new double[n];
        preSum[0] = A[0];
        //k = 1
        double[] dp = new double[n];
        dp[0] = A[0];
        for (int i = 1; i< n; i++) {
            preSum[i] += preSum[i - 1] + A[i];
            dp[i] = preSum[i]/(i + 1);
        }
        //put the first i element into k group
        for (int k = 2; k <= K; k++) {
            double[] tmp = new double[n];
            for (int i = k - 1; i < n; i++) {
                double maxAvg = 0.0;
                double avg = 0.0;
                for (int j =0; j < i; j ++) {
                    avg = dp[j] + ((preSum[i] - preSum[j])/(i - j));
                    maxAvg = Math.max(maxAvg, avg);
                }
                tmp[i] = maxAvg;
            }
            dp = tmp;
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        int[] nums = new int[]{9, 1, 2,3,9};
        double ans = largestSumOfAverages(nums, 3);
    }
}
