package sort;
import java.util.LinkedList;

import org.junit.Test;

public class MaximumErasureValue{
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] isPresent = new boolean[10001];
        int globalMax = 0;
        int j = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
           while (isPresent[nums[i]]) {
               isPresent[nums[j]] = false;
               maxSum -= nums[j];
               j++;
           }
            isPresent[nums[i]] = true;
            maxSum += nums[i];
            
            globalMax = Math.max(globalMax, maxSum);
        }
        return globalMax;
    }

    // @Test
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,4,5,6};
        MaximumErasureValue test = new MaximumErasureValue();
        test.maximumUniqueSubarray(arr);
    }
}
