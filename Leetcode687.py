from TreeNode import TreeNode
class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.ans = 0
        self.getPath(root)
        return self.ans
    def getPath(self, root):
        if not root:
            return 0
        leftPath = self.getPath(root.left)
        rightPath = self.getPath(root.right)
        left_arrow = right_arrow = 0
        if root.left and root.left.val == root.val:
            left_arrow = 1 + leftPath
        if root.right and root.right.val == root.val:
            right_arrow = 1 + rightPath
        # return leftPath + rightPath
        self.ans = max(self.ans, right_arrow + left_arrow)
        return max(left_arrow, right_arrow)

def main():
    sol = Solution()
    # left = TreeNode(5, TreeNode(5, None, None), TreeNode(1, None, None))
    # right = TreeNode(5, None, TreeNode(5, None, None))
    # root = TreeNode(5, left, right)
    # right = TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None))
    # root = TreeNode(1, None, TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None)))
    left = TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None))


    left1 = TreeNode(4, TreeNode(4, TreeNode(4, TreeNode(4, None, None), None), None), TreeNode(4, None, TreeNode(4, None, TreeNode(4, None, None))))
    left2 = TreeNode(4, left1, TreeNode(4, None, None))
    right1 = TreeNode(5, None, TreeNode(4, None, TreeNode(4, TreeNode(4, None, None), None)))
    right2 = TreeNode(5, right1, TreeNode(3, None, None))
    root = TreeNode(5, left2, right2)
    result = sol.longestUnivaluePath(root)

    print(result)

if __name__ == "__main__":
    main()