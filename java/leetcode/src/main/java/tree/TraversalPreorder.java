package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalPreorder {
    List<Integer> ans = new ArrayList<>();
    public void preorder(Node root){
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * iterate while + stack
     * @param root
     */
    public List<Integer> preorder_(Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            Node topEle = stack.pop();
            root = topEle.right;
        }
        return ans;
    }
    public static void main(String[] args){
        Integer[] nums = new Integer[]{1, 2,3, null, null, 4,5};
        Node root = Node.buildTree(nums, 0);
        TraversalPreorder traversalPreorder = new TraversalPreorder();
        traversalPreorder.preorder(root);
        List<Integer> res = traversalPreorder.ans;
    }
}
