package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * typical bfs + level size measurement
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //level size measurement
            int levelSize = queue.size();
            int i = 0;
            while (i < levelSize) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (i == levelSize - 1) {
                        ans.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                i++;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{1,2,3,null,5,null,4};
        TreeNode root = TreeNode.buildTree(nums, 0);
        List<Integer> ans = rightSideView(root);
        nums = new Integer[]{1, 2};
        root = TreeNode.buildTree(nums, 0);
        ans = rightSideView(root);
    }
}
