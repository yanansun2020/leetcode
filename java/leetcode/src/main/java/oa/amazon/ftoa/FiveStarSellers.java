package oa.amazon.ftoa;

import org.junit.Test;

/**
 * time O(n)
 * space O(1)
 */
public class FiveStarSellers {
    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
        int n = productRatings.length;
        double rate = getRate(productRatings);
        int count = 0;
        while (rate < ratingsThreshold * n) {
            double maxRate = rate;
            int maxIndex = -1;
            for (int i = 0; i < n; i++) {
                double originalRate = ((double) productRatings[i][0]/productRatings[i][1]) * 100;
                double pluseOneRate = ((productRatings[i][0] + 1.0) /(productRatings[i][1] + 1)) * 100;
                double newRate = rate - originalRate + pluseOneRate;
                if (newRate > maxRate) {
                    maxRate = newRate;
                    maxIndex = i;
                }
            }
            if (maxIndex != -1) {
                productRatings[maxIndex][0]++;
                productRatings[maxIndex][1]++;
                count++;
                rate = maxRate;
            }
        }
        return count;
    }
    static double getRate(int[][] productRatings){
        double rate = 0.0;
        for (int[] rating : productRatings) {
            rate += ((double)rating[0]/rating[1]);
        }
        return rate*100;
    }

    @Test
    public void test(){
        int[][] nums = new int[][]{{4,4}, {1,2}, {3, 6}};
        int ans = fiveStarReviews(nums, 77);
    }
}
