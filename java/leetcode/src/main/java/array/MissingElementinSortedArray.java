package array;

public class MissingElementinSortedArray {
    public int missingElement(int[] nums, int k) {
        for(int i =1; i < nums.length; i++){
            int range = nums[i] - nums[i-1] - 1;
            if(range < k){
                k = k - range;
            }else{
                return nums[i-1] + k;
            }
        }
        return nums[nums.length - 1] + k;
    }
}
