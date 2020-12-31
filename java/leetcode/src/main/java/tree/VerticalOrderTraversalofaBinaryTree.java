package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeMap<Integer, List<V>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        for (Map.Entry<Integer, List<V>> entry : map.entrySet()) {
            List<V> values = entry.getValue();
            Collections.sort(values, (o1, o2)->o2.positionY == o1.positionY? o1.value - o2.value: o2.positionY - o1.positionY);
            ans.add(values.stream().map(V::getValue).collect(Collectors.toList()));
        }
        return ans;
    }
    public void dfs(TreeNode node, TreeMap<Integer, List<V>> map, int x, int y){
        if (node == null){
            return;
        }
        List<V> values = map.getOrDefault(x, new ArrayList<>());
        values.add(new V(node.val, y, x));
        map.put(x, values);
        dfs(node.left, map, x -1, y -1);
        dfs(node.right, map, x + 1, y -1);
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9};
        TreeNode node = TreeNode.buildTree(nums);
        List<List<Integer>> ans = verticalTraversal(node);
    }
}

class V{
    int value;
    int positionY;
    int positionX;
    V(){}
    V(int value, int positionY, int positionX){
        this.value = value;
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public int getValue() {
        return value;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }
}
