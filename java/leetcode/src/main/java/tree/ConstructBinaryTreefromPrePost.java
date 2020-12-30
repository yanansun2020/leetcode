package tree;

import org.junit.Test;

public class ConstructBinaryTreefromPrePost {
    int preIndex;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preIndex = 0;
        if (pre == null || pre.length == 0 ||post ==null||post.length == 0 ){
            return null;
        }
        TreeNode root = buildTree(pre, post, 0, post.length - 1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int posOrderStart, int posorderEnd){
        if (posOrderStart > posorderEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if (posOrderStart == posorderEnd) {
            return node;
        }
        if (preIndex < preorder.length) {
            int inOrderIndex = getInorderIndex(inorder, preorder[preIndex], posOrderStart, posorderEnd);
            if (inOrderIndex >= 0) {
                node.left = buildTree(preorder, inorder, posOrderStart, inOrderIndex);
                node.right = buildTree(preorder, inorder, inOrderIndex + 1, posorderEnd - 1);
            }
        }

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
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] pos = new int[]{4,5,2,6,7,3,1};
        TreeNode node = constructFromPrePost(pre, pos);
        pre = new int[]{3,4,1,2};
        pos = new int[]{1,4,2,3};
        node = constructFromPrePost(pre, pos);

    }
}
