package contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * if the product of all number > 0; return length
 * else:
 * for any negative number, then the array contains an odd number of negative elements,
 * the product of its left side and right side is positive
 *
 */
public class MaximumLength {
    public int getMaxLen(int[] nums) {
        int start = 0;
        int maxLength = 0;
        List<int[]> numsList = new ArrayList<>();
        for(int i =0; i < nums.length; i++){
            if(nums[i] == 0){
                if(start < i-1){
                    numsList.add(new int[]{start, i-1});
                }
                start = i + 1;
            }
        }
        numsList.add(new int[]{start, nums.length-1});
        for(int[] startEnd : numsList){
            maxLength = Math.max(maxLength, findMaxLength(startEnd[0], startEnd[1], nums));
        }
        return maxLength;
    }

    private int findMaxLength(int start, int end, int[] nums) {
        int product = 1;
        for(int i = start; i <= end; i++){
            if(nums[i] > 0){
                product *= 1;
            }else{
                product *= -1;
            }
        }
        if(product > 0){
            return end - start + 1;
        }
        int maxLength = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] < 0){
                maxLength = Math.max(maxLength, Math.max(i - start, end-i));
            }
        }
        return maxLength;
    }
    @Test
    public void test(){
        int a = getMaxLen(new int[]{1,-2,-3,4});
        int a1 = getMaxLen(new int[]{0,1,-2,-3,-4});
        int a2 = getMaxLen(new int[]{-1,-2,-3,0,1});
        int a3 = getMaxLen(new int[]{-1,2});
        int a4 = getMaxLen(new int[]{1,2,3,5,-6,4,0,10});
    }
}
