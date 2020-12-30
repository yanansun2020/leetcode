package tree;

import org.junit.Test;

/**
 * 先构建左子树， 再右子树
 *
 */
public class ConstrBinaryTreefromPreandInorder {
    int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||inorder ==null||inorder.length == 0 ){
            return null;
        }
        preOrderIndex = 0;
        TreeNode root = buildTree(preorder, inorder, 0, inorder.length - 1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int inOrderStart, int inorderEnd){
        if (inOrderStart > inorderEnd) {
            return null;
        }
        if (inOrderStart == inorderEnd) {
            return new TreeNode(preorder[preOrderIndex++]);
        }
        TreeNode node = new TreeNode(preorder[preOrderIndex++]);
        int inOrderIndex = getInorderIndex(inorder, node.val, inOrderStart, inorderEnd);
        node.left = buildTree(preorder, inorder, inOrderStart, inOrderIndex - 1);
        node.right = buildTree(preorder, inorder, inOrderIndex + 1, inorderEnd);
        return node;
    }

    private int getInorderIndex(int[] inorder, int rootValue, int start, int end){
        for (int i = start; i<= end; i++) {
            if (inorder[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{2,1};
        TreeNode node = buildTree(preorder, inorder);
    }
}
