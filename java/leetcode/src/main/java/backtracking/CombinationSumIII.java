package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 1, n, k, cur, res);
        return res;
    }

    private void dfs(int curSum, int startNumber, int target, int k, List<Integer> cur, List<List<Integer>> res) {
        if (curSum == target) {
            if (cur.size() == k) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        if (cur.size() > k || startNumber >= 10 || curSum > target) {
            return;
        }
        for (int i = startNumber; i <= 9; i++) {
            cur.add(i);
            dfs(curSum + i, i + 1, target, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
