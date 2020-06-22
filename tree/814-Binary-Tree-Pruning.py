# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        if root.val == 0 and not root.left and not root.right:
            return None
        return root

def main():
    sol = Solution()
    left = TreeNode(1, TreeNode(1, TreeNode(0)), TreeNode(1))
    right = TreeNode(0, TreeNode(0), TreeNode(1))
    root = TreeNode(1, left, right)
    result = sol.pruneTree(root)
    print(result)

if __name__ == "__main__":
    main()