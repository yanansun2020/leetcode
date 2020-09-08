package tree;

import org.junit.Test;

import java.util.Stack;

public class ConstructBinaryTreefromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                i++;
                if (i >= s.length()) {
                    break;
                }
            }
            if (i > j) {
                int value = Integer.parseInt(s.substring(j, i));
                TreeNode cur = new TreeNode(value);
                TreeNode top = stack.isEmpty()? null : stack.peek();
                if (top != null) {
                    if (top.left == null) {
                        top.left = cur;
                    } else if (top.right == null) {
                        top.right = cur;
                    }
                }
                stack.push(cur);
            }
            if (i < s.length() && s.charAt(i) == ')') {
                stack.pop();
            }
            i++;
        }
        return stack.pop();
    }

    @Test
    public void test(){
        TreeNode root = str2tree("4(2(3)(1))(6(5))");
        TreeNode root1 = str2tree("4(2(3)(1))(6(5)(7))");
        TreeNode root2 = str2tree("-4(2(3)(1))(6(5)(7))");
        TreeNode root3 = str2tree("-4");
    }
}
