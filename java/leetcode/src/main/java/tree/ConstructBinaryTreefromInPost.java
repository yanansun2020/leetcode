package tree;

import org.junit.Test;

/**
 * 先构建右子树， 再左子树
 */
public class ConstructBinaryTreefromInPost {
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return buildTree(inorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postIndex--]);
        if (startIndex == endIndex) {
            return node;
        }
        int inOrderIndex = getInorderIndex(inorder, node.val);
        node.right = buildTree(inorder, postorder, inOrderIndex + 1, endIndex);
        node.left = buildTree(inorder, postorder, startIndex, inOrderIndex - 1);
        return node;
    }
    private int getInorderIndex(int[] inorder, int rootValue){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] inorder = new int[]{2,1};
        int[] postorder = new int[]{2,1};
        TreeNode node = buildTree(inorder, postorder);
    }
}
