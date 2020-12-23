package slidingwindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){
                List<List<Integer>> res = threeSum(nums, target - nums[i], i  + 1, nums[i]);
                ans.addAll(res);
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int start, int value) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i < nums.length; i++) {
            if (i == start || (i > start && nums[i] != nums[i-1])){
                ArrayList<ArrayList<Integer>> res1 = twoSum(i + 1, nums.length - 1, nums, target - nums[i]);
                if (res1 != null){
                    for (List<Integer> lst : res1) {
                        lst.add(nums[i]);
                        lst.add(value);
                        res.add(lst);
                    }
                }
            }
        }
        return res;
    }
    private ArrayList<ArrayList<Integer>> twoSum(int low, int high, int[] nums, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                ArrayList<Integer> res = new ArrayList<>(Arrays.asList(nums[low], nums[high]));
                while (low < high && nums[low] == nums[++low]) {
                }
                while (high > low && nums[high] == nums[--high]) {
                }
                ans.add(res);
            }
            if (nums[low] + nums[high] < target) {
                low++;
            }
            if (nums[low] + nums[high] > target) {
                high--;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,0,-1,0,-2,2};
        nums = new int[]{-2,-1,-1,1,1,2,2};
        List<List<Integer>> ans = fourSum(nums, 0);
    }
}
