package contest;

import org.junit.Assert;
import org.junit.Test;

public class GettheMaximumScore {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int M = nums1.length;
        int N = nums2.length;
        int count = 0;
        long accumulate1 =0;
        long accumulate2 = 0;

        while(i < M || j < N){
            if(i < M && ( j == N || nums1[i] < nums2[j])){
                accumulate1 += nums1[i];
                i++;
                continue;
            }
            if(j < N && (i == M || nums1[i] > nums2[j])){
                accumulate2 +=  nums2[j];
                j ++;
                continue;
            }
            count += Math.max(accumulate1, accumulate2) + nums1[i];
            accumulate1 = 0;
            accumulate2 = 0;
            i ++;
            j++;
        }
        long mod = (long)1e9 + 7;
        return (int)((count + Math.max(accumulate1, accumulate2))%mod);
    }
    @Test
    public void test(){
        int[] nums1 = {2,4,5,8,10};
        int[] nums2 = {4,6,8,9};
        int result = maxSum(nums1, nums2);
        Assert.assertTrue(result==30);
        int[] nums1_1 = {1,3,5,7,9};
        int[] nums2_1 = {3,5,100};
        int result_1 = maxSum(nums1_1, nums2_1);
        Assert.assertTrue(result_1==109);
        int[] nums1_2 = {1,2,3,4,5};
        int[] nums2_2 = {6,7,8,9,10};
        int result_2 = maxSum(nums1_2, nums2_2);
        Assert.assertTrue(result_2==40);
    }
}
