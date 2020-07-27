# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        self.max_difference = 0
        def get_min_max(node):
            if not node:
                return None
            if not node.left and not node.right:
                return (node.val, node.val)
            min_max_left = get_min_max(node.left)
            min_max_right = get_min_max(node.right)
            if not min_max_left:
                min_max_left = min_max_right
            if not min_max_right:
                min_max_right = min_max_left
            min_value = min(min_max_left[0], min_max_right[0])
            max_value = max(min_max_left[1], min_max_right[1])
            max_differ = max(abs(node.val - min_value), abs(node.val - max_value))
            if self.max_difference < max_differ:
                self.max_difference = max_differ
            return (min(node.val, min_value, min_max_left[1], min_max_right[1]), \
                max(node.val, min_max_left[0], max_value, min_max_right[0]))
        get_min_max(root)
        return self.max_difference
def main():
    sol = Solution()
    left = TreeNode(3, TreeNode(1), TreeNode(6, TreeNode(4), TreeNode(7)))
    right = TreeNode(10, None, TreeNode(14, TreeNode(13)))
    root = TreeNode(8, left, right)
    result = sol.maxAncestorDiff(root)
    print(result)

if __name__ == "__main__":
    main()