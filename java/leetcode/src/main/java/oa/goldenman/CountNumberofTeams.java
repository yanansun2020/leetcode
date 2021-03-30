package oa.goldenman;

import org.junit.Test;

/**
 * count number of elements less or greater than ith item
 */
public class CountNumberofTeams {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftLess = 0;
            int rightGreater = 0;

            int leftGreater = 0;
            int rightLess = 0;
            for (int j = i -1; j >= 0; j --) {
                if(rating[i] > rating[j]) {
                    leftLess++;
                } else {
                    leftGreater++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    rightGreater++;
                } else {
                    rightLess++;
                }
            }
            res += (leftLess * rightGreater + leftGreater * rightLess);
        }
        return res;
    }
    @Test
    public void test () {
        int[] nums = new int[]{2, 5, 3, 4, 1};
        int ans = numTeams(nums);
    }
}
