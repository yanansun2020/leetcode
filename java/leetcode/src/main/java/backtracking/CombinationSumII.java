package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, target, 0, cur, res, candidates);
        return res;
    }

    private void dfs(int curSum, int target, int startIndex, List<Integer> cur, List<List<Integer>> res, int[] nums) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList(cur));
            return;
        }
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(curSum + nums[i], target, i + 1, cur, res, nums);
            //skip the same element
            while (i + 1 < nums.length && nums[i + 1] == nums[i]){
                i++;
            }
            cur.remove(cur.size() - 1);
        }
    }
}
