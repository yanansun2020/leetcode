# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        result = self.getChild(root, target)
        return result

    def getChild(self, root, target):
        if not root:
            return None
        root.left = self.getChild(root.left, target)
        root.right = self.getChild(root.right, target)
        if root.val == target:
            if not root.left and not root.right:
                return None
        return root

def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(2))
    right = TreeNode(3, TreeNode(2), TreeNode(6))
    # root = TreeNode(1, left, right)
    root = TreeNode(1, TreeNode(1), TreeNode(1))
    result = sol.removeLeafNodes(root, 1)
    print(result)
if __name__ == "__main__":
    main()
