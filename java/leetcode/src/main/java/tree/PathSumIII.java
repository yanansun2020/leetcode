package tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * prefix sum
 */
public class PathSumIII {
    int count;
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        prefixsum(root, sum, 0, preSumMap);
        return count;
    }

    public void prefixsum(TreeNode node, int target, int curSum, Map<Integer, Integer> preSumMap){
        if (node == null) {
            return;
        }
        curSum += node.val;
        if (curSum == target) {
            count++;
        }
        count += preSumMap.getOrDefault(curSum - target, 0);
        preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) + 1);
        prefixsum(node.left, target, curSum, preSumMap);
        prefixsum(node.right, target, curSum, preSumMap);
        preSumMap.put(curSum, preSumMap.get(curSum) - 1);
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNode.buildTree(nums);
        int ans = pathSum(root, 8);
    }
}
