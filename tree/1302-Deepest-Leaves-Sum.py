# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    result = 0
    def deepestLeavesSum(self, root: TreeNode) -> int:
        depth = self.getDepth(root, 0)
        self.result = 0
        self.sum(root, depth)
        return self.result

    def sum(self, root, depth):
        if not root:
            return
        depth -= 1
        if depth == 0:
            self.result += root.val
        self.sum(root.left, depth)
        self.sum(root.right, depth)

    def getDepth(self, root, depth):
        if not root:
            return 0
        left_depth = 1 + self.getDepth(root.left, depth)
        right_depth = 1 + self.getDepth(root.right, depth)
        return max(left_depth, right_depth)



def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5))
    right = TreeNode(3, None, TreeNode(6, None, TreeNode(8)))

    root = TreeNode(1, left, right)
    result = sol.deepestLeavesSum(root)
    print(result)
if __name__ == "__main__":
    main()
