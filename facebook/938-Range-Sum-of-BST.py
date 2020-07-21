class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root:
            return 0
        if root.val < L:
            return self.rangeSumBST(root.right, L, R)
        elif root.val > R:
            return self.rangeSumBST(root.left, L, R)
        else:
            left_val = self.rangeSumBST(root.left, L, R)
            right_val = self.rangeSumBST(root.right, L, R)
            return left_val + right_val + root.val
