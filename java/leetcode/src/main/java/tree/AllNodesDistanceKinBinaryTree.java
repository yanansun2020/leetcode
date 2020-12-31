package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * convert tree to graph represent as adjacent list
 * Then bfs to determine the depth
 */
public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        convertToGraph(root, null, map);
        return bfs(map, target, K);
    }
    private List<Integer> bfs(Map<Integer, List<TreeNode>> map, TreeNode target, int K){
        List<Integer> ans = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (!queue.isEmpty() && K >= 0) {
            int queSize = queue.size();
            for (int i = 0; i < queSize; i++) {
                TreeNode cur = queue.poll();
                if (K == 0) {
                    ans.add(cur.val);
                    continue;
                }
                List<TreeNode> neighbors = map.get(cur.val);
                for (TreeNode neighbor : neighbors) {
                    if (!visited.contains(neighbor.val)) {
                        queue.offer(neighbor);
                    }
                }
                visited.add(cur.val);
            }
            K--;
        }
        return ans;
    }

    /**
     * dfs to convert the tree to a graph
     * @param node
     * @param parent
     * @param map
     */
    private void convertToGraph(TreeNode node, TreeNode parent, Map<Integer, List<TreeNode>> map){
        if (node == null) {
            return;
        }
        List<TreeNode> adjacent = map.getOrDefault(node.val, new ArrayList<>());
        if (parent != null) {
            adjacent.add(parent);
        }
        if (node.left != null) {
            adjacent.add(node.left);
        }
        if (node.right != null) {
            adjacent.add(node.right);
        }
        map.put(node.val, adjacent);
        convertToGraph(node.left, node, map);
        convertToGraph(node.right, node, map);
    }

    @Test
    public void test(){
        Integer[] nums = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.buildTree(nums);
        TreeNode target = new TreeNode(5);
        List<Integer> lst = distanceK(root, target, 2);
    }
}
