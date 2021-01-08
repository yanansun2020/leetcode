package greedy;

public class JumpGame {
    /**
     * check the longest path a node can reachable
     */
    public boolean canJump(int[] nums) {
        int reachableIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachableIndex < i) {
                return false;
            }
            reachableIndex = Math.max(reachableIndex, nums[i] + i);
            if (reachableIndex ==nums.length - 1 ) {
                return true;
            }

        }
        return reachableIndex >= nums.length - 1;
    }
}
