from TreeNode import TreeNode
class Solution:
    def isUnivalTree(self, root: TreeNode) -> bool:
        return self.getResult(root, root.val)

    def getResult(self, node, value):
        if not node:
            return True
        if node.val != value:
            return False
        isUnionLeft = self.getResult(node.left, value)
        if not isUnionLeft:
            return False
        isUnionRight = self.getResult(node.right, value)
        return isUnionRight


def main():
    sol = Solution()
    root = TreeNode(1, TreeNode(1, None, None), TreeNode(2, None, None))
    result = sol.isUnivalTree(root)
    print(result)

if __name__ == "__main__":
    main()
