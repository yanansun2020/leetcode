from TreeNode import TreeNode
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.result =0
        self.getPath(root)
        return self.result

    def getPath(self, root):
        if not root:
            return 0
        leftPath = self.getPath(root.left)
        rightPath = self.getPath(root.right)
        if root.left:
            leftPath = 1 + leftPath
        if root.right:
            rightPath = 1 + rightPath
        self.result = max(self.result, leftPath + rightPath)
        return max(leftPath, rightPath)

def main():
    sol = Solution()
    # left = TreeNode(5, TreeNode(5, None, None), TreeNode(1, None, None))
    # right = TreeNode(5, None, TreeNode(5, None, None))
    # root = TreeNode(5, left, right)
    # right = TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None))
    # root = TreeNode(1, None, TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None)))
    # left = TreeNode(1, TreeNode(1, None, None), TreeNode(1, None, None))


    # left1 = TreeNode(4, TreeNode(4, TreeNode(4, TreeNode(4, None, None), None), None), TreeNode(4, None, TreeNode(4, None, TreeNode(4, None, None))))
    # left2 = TreeNode(4, left1, TreeNode(4, None, None))
    # right1 = TreeNode(5, None, TreeNode(4, None, TreeNode(4, TreeNode(4, None, None), None)))
    # right2 = TreeNode(5, right1, TreeNode(3, None, None))
    # root = TreeNode(5, left2, right2)
    root = TreeNode(2, TreeNode(1, None, None), TreeNode(3, None, None))
    result = sol.diameterOfBinaryTree(root)

    print(result)

if __name__ == "__main__":
    main()
