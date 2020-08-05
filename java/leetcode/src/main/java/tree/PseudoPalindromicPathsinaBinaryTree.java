package tree;
import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsinaBinaryTree {
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(root, map);

        //return count;
    }
    public int dfs_bit(TreeNode node, Integer count){
        if(node == null){
            return 0;
        }
        count ^= (1<<node.val);
        if (node.left == null && node.right == null){
            return (count & (count-1)) == 0? 1 : 0;
        }
        int left = dfs_bit(node.left, count);
        int right = dfs_bit(node.right, count);
        return left + right;
    }
    public int dfs(TreeNode node, Map<Integer, Integer> frequency){
        if(node == null){
            return 0;
        }
        frequency.put(node.val, frequency.getOrDefault(node.val, 0) + 1);
        if (node.left == null && node.right == null){
            boolean oneOdd = atMostOneOdd(frequency);
            frequency.put(node.val, frequency.get(node.val) - 1);
            return oneOdd? 1 : 0;
        }
        int left = dfs(node.left, frequency);
        int right = dfs(node.right, frequency);
        frequency.put(node.val, frequency.get(node.val) - 1);
        return left + right;
    }

    public boolean atMostOneOdd(Map<Integer, Integer> frequency){
        int number_odd = 0;
        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()){
            if(entry.getValue() % 2 ==1){
                number_odd++;
            }
            if (number_odd > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PseudoPalindromicPathsinaBinaryTree test = new PseudoPalindromicPathsinaBinaryTree();
        TreeNode right = new TreeNode(1, null, new TreeNode(1));
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), right);
        int result = test.pseudoPalindromicPaths(root);
        System.out.println(result);

    }
}