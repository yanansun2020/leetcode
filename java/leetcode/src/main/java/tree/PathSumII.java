package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        findNodes(root, sum, res);
        return ans;
    }
    public void findNodes(TreeNode node, int sum, LinkedList<Integer> res){
        if (node == null) {
            return;
        }
        res.addLast(node.val);
        if (isLeaf(node) && node.val == sum) {
            ans.add(new ArrayList<Integer>(res));
            res.removeLast();
            return;
        }
        findNodes(node.left, sum - node.val, res);
        findNodes(node.right, sum - node.val, res);
        res.removeLast();

    }
    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
}
