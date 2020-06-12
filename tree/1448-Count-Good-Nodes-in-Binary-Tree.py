# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        self.count = 0
        def getCount(node, maximum_value):
            if not node:
                return
            if node.val >= maximum_value:
                self.count += 1
                maximum_value = node.val
            getCount(node.left, maximum_value)
            getCount(node.right, maximum_value)
        getCount(root, root.val)
        return self.count
def main():
    sol = Solution()
    left = TreeNode(1, TreeNode(3))
    right = TreeNode(4, TreeNode(1), TreeNode(5))
    root = TreeNode(3, left, right)
    result = sol.goodNodes(root)
    print(1)
if __name__ == "__main__":
    main()

