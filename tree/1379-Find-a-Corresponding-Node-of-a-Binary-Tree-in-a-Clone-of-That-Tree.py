# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from TreeNode import TreeNode
class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if not original:
            return None
        if original.val == target.val:
            return cloned
        left = self.getTargetCopy(original.left, cloned.left, target)
        if not left:
            right = self.getTargetCopy(original.right, cloned.right, target)
            return right if right else None
        else:
            return left
def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3, TreeNode(6), TreeNode(7))
    root = TreeNode(1, left, right)
    result = sol.getTargetCopy(root, root, left)
    print(1)
if __name__ == "__main__":
    main()
