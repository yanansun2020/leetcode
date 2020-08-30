package tree;

import java.util.Stack;

public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if(flag){
                return top;
            }
            if(top.val == p.val){
                if(top.right == null){
                    TreeNode peekNode = stack.isEmpty()? null : stack.peek();
                    return peekNode;
                }else{
                    flag = true;
                }
            }
            root = top.right;
        }
        return null;
    }
}
