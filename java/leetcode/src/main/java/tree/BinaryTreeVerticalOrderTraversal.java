package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<NodeDepth> queue = new LinkedList<>();
        queue.offer(new NodeDepth(root, 0));
        Map<Integer, List<Integer>> map = new TreeMap<>((o1, o2)->o1.compareTo(o2));
        while(!queue.isEmpty()){
            NodeDepth nodeDepth = queue.poll();
            int curDepth = nodeDepth.depth;
            TreeNode curNode = nodeDepth.node;
            List<Integer> values = map.get(curDepth);
            if(values == null || values.isEmpty()){
                values = new ArrayList<>();
            }
            values.add(curNode.val);
            map.put(curDepth, values);
            if(curNode.left != null){
                queue.offer(new NodeDepth(curNode.left, curDepth-1));
            }
            if(curNode.right != null){
                queue.offer(new NodeDepth(curNode.right, curDepth+1));
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
class NodeDepth{
    TreeNode node;
    int depth;
    NodeDepth(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
