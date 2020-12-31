package tree;

import org.junit.Test;

public class PathSumIV {
    public int pathSum(int[] nums) {
        int sum = 0;
        int length = nums.length;
        int[] sumArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sumArray[0] = (nums[0]%100) %10;
            }
            int leftIndex = 2 *i + 1;
            int rightIndex = 2 *i + 2;
            if (leftIndex < length) {
                sumArray[leftIndex] = sumArray[i] + (nums[leftIndex]%100)%10;
            }
            if (rightIndex < length) {
                sumArray[rightIndex] = sumArray[i] + (nums[rightIndex]%100)%10;
            }
            if (isLeaf(i, nums)) {
                sum += sumArray[i];
            }
        }
        return sum;
    }
    private boolean isLeaf(int i, int[] nums){
        if (2 * i + 1 >= nums.length) {
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        int[] nums = new int[]{113, 215, 221};
        int ans = pathSum(nums);
    }
}
