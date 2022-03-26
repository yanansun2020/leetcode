package backtracking;

import java.util.*;

public class MatchstickstoSquare {
    public boolean makesquare(int[] matchsticks) {
        int side = getSide(matchsticks);
        if (side == 0) {
            return false;
        }
        for (int i = 0; i < matchsticks.length; i++) {
            matchsticks[i] = matchsticks[i] * -1;
        }
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length; i++) {
            matchsticks[i] = matchsticks[i] * -1;
        }

        LinkedList<Integer> res = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[matchsticks.length];
        for (int i = 0; i <matchsticks.length; i++ ) {
            if (visited[i] == 0) {
                boolean find = dfs(i, side, 0, matchsticks, res, ans, visited);
                if (!find) {
                    return false;
                }
            }
        }

        int curSize = 0;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) return false;
        }
        return true;
    }

    private boolean dfs(int start, int target, int sum, int[] nums, LinkedList<Integer> res, List<List<Integer>> ans, int[] used) {
        if (sum > target || start > nums.length) {
            return false;
        }
        if (target == sum) {
            for (Integer n : res) {
                used[n] = 1;
            }
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            //visited[i] = 1;
            res.add(i);
            boolean searchRes = dfs(i + 1, target, sum + nums[i], nums, res, ans, used);
            res.removeLast();
            if (searchRes) {
                return true;
            }
//            while(i + 1 < nums.length && nums[i + 1] == nums[i]) {
//                i++;
//            }
            //visited[i] = 0;

        }
        return false;
    }

    private int getSide(int[] sticks) {
        int sum = 0;
        for (int i = 0; i < sticks.length; i++) {
            sum += sticks[i];
        }
        if (sum % 4 == 0) {
            return sum / 4;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,6,5,5,5,3,3,3,2,2,2,2};
        MatchstickstoSquare matchstickstoSquare = new MatchstickstoSquare();
        boolean res = matchstickstoSquare.makesquare(nums);
        System.out.println(res == true);
        nums = new int[]{1,1,2,2,2};
        res = matchstickstoSquare.makesquare(nums);
        System.out.println(res == true);
        nums = new int[]{3,3,3,3,4};
        res = matchstickstoSquare.makesquare(nums);
        System.out.println(res == false);
        nums = new int[]{13,11,1,8,6,7,8,8,6,7,8,9,8};
        res = matchstickstoSquare.makesquare(nums);
        System.out.println(res == true);

    }
}
