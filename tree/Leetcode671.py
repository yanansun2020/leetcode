from TreeNode import TreeNode
class Solution:
    result = -1
    rootValue = -1
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        if not root or (not root.left and not root.right):
            return self.result
        if root.val == root.left.val:
            self.result = root.right.val
        if root.val == root.right.val:
            self.result = root.left.val
        self.rootValue = root.val
        self.getResult(root)
        if self.rootValue == self.result:
            return -1
        return self.result

    def getResult(self, root):
        if not root.left or not root.right:
            return
        if root.left and root.right:
            maxValue = max(root.left.val, root.right.val)
            if maxValue != self.rootValue and maxValue < self.result:
                self.result = maxValue
            if root.val == root.left.val:
                self.getResult(root.left)
            if root.val == root.right.val:
                self.getResult(root.right)

def main():
    sol = Solution()
    root = TreeNode(2, TreeNode(2, None, None), TreeNode(5, TreeNode(5, None, None), TreeNode(7, None, None)))
    # root = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1, None, None), None)), TreeNode(4, None, None))
    # result = sol.findSecondMinimumValue(root)
    # print(result)
    # root = TreeNode(2, TreeNode(2, None, None), TreeNode(2, None, None))
    # result = sol.findSecondMinimumValue(root)
    # print(result)
    root = TreeNode(1, TreeNode(1, TreeNode(1, None, None), TreeNode(2, None, None)), TreeNode(3, None, FileNotFoundError))
    result = sol.findSecondMinimumValue(root)
    print(result)
if __name__ == "__main__":
    main()