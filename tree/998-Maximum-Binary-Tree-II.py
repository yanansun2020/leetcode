# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def insertIntoMaxTree(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return TreeNode(val)
        if root.val < val:
            root_1 = TreeNode(val)
            root_1.left = root
            return root_1
        root.right = insertIntoMaxTree(root.right, val)
        return root

