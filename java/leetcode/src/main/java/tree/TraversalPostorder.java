package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalPostorder {
    List<Integer> ans = new ArrayList<>();
    public void postorder(Node root){
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);
    }
    public List<Integer> postorder_(Node root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node previous = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            Node node = stack.peek();
            Node right =  node.right;
            if(right == null || right == previous){
                previous = node;
                stack.pop();
                result.add(node.val);
            }else{
                root = right;
            }
        }
        return result;
    }
}
