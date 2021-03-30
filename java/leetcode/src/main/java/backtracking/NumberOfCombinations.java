package backtracking;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NumberOfCombinations {

    public int combinationSum2(int[] candidates, int target) {
        Map<String, Integer> map = new HashMap<>();
        int ans = dfs(0, target, 0, candidates, map);
        System.out.println(map);
        return ans;
    }

    private int dfs(int curSum, int target, int startIndex, int[] nums, Map<String, Integer> map) {
        if (curSum > target) {
            return 0;
        }
        if (map.get(curSum + "" + startIndex) != null) {
            return map.get(curSum + "" + startIndex);
        }
        if (curSum == target) {
            return 1;
        }
        int sum = 0;
        for (int i = startIndex; i < nums.length; i++) {
            sum += dfs(curSum + nums[i], target, i, nums, map);
        }
        map.put(curSum + "" + startIndex, map.getOrDefault(curSum + "" + startIndex, 0) + 1);
        return sum;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,3,4};
        int ans = combinationSum2(nums, 6);
        System.out.println(ans);
    }
}
