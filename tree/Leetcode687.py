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
        #left_arrow = right_arrow = 0
        if root.left:
            if root.left.val == root.val:
                leftPath = 1 + leftPath
            else:
                leftPath = 0
        if root.right:
            if root.right.val == root.val:
                rightPath = 1 + rightPath
            else:
                rightPath = 0
        # return leftPath + rightPath
        #if root.left and root.right and root.val == root.left.val and root.val == root.right.val:
        self.ans = max(self.ans, rightPath + leftPath)
        # else:
        #     maxV = max(rightPath, leftPath)
        #     self.ans = max( self.ans, maxV)
        return max(rightPath, leftPath)


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