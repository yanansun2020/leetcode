package tree;

import org.junit.Test;

/**
 * similar to DiameterofBinaryTree
 * keep track of the maxlength and secondMaxlength on each level
 */
public class DiameterofNAryTree {
    int ans;
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        getMaxLength(root);
        return ans;
    }

    private int getMaxLength(Node node){
        if (node == null) {
            return 0;
        }
        int maxLength = 0;
        int secondMaxLength = 0;
        for (Node child : node.children) {
            int length = 1 + getMaxLength(child);
            if (length > maxLength) {
                secondMaxLength = maxLength;
                maxLength = length;
            } else if (length > secondMaxLength){
                secondMaxLength = length;
            }
        }
        ans = Math.max(secondMaxLength + maxLength + 1, ans);
        return maxLength;
    }
    @Test
    public void test(){

    }
}
