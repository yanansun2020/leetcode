package slidingwindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sort array
 * two pointers one points to low, one points to high, move toward each other
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = 0-nums[i];
                List<List<Integer>> ans = twoSum(i + 1, nums.length - 1, nums, target);
                if (ans != null){
                    res.addAll(ans);
                }
            }

        }
        return res;
    }
    private List<List<Integer>> twoSum(int low, int high, int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                List<Integer> res = Arrays.asList(nums[low], nums[high], 0 - target);
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
        List<List<Integer>> res = threeSum(new int[]{0, 0, 0});
    }
}
