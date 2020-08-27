package tree;

import org.junit.Test;

import java.util.Stack;

public class ClosestBinarySearchTreeValue {
    TreeNode ans;
    public int closestValue(TreeNode root, double target) {
        /*ans = root;
        closest(root, target, Integer.MAX_VALUE);
        return ans != null ? ans.val:-1;*/
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = null;
        double difference = Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            double absValue = Math.abs(node.val - target);
            if(absValue < difference){
                difference = absValue;
                ans = node;
            }
            root = node.right;
        }
        return ans.val;
    }
    public void closest(TreeNode node, double target, double difference){
        if(node == null){
            return;
        }
        double diff = Math.abs(node.val - target);
        if(diff > difference){
            closest(node.right, target, difference);
        }else{
            ans = node;
            closest(node.left, target, diff);
        }
    }
    @Test
    public void test(){
        /*TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        int ans = closestValue(root, 3.714286);*/

        TreeNode root = new TreeNode(1500000000, new TreeNode(1400000000), null);
        int ans = closestValue(root, -1500000000.0);
    }
}
