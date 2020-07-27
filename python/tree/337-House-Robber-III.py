# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# for each node, return a tuple(max value include the node, max value not include the node)
from TreeNode import TreeNode
import collections
class Solution:
    def rob(self, root: TreeNode) -> int:
        def rob_house(root):
            if not root:
                return (0, 0)
            left_tuple = rob_house(root.left)
            right_tuple = rob_house(root.right)
            not_steal = max(left_tuple[0], left_tuple[1]) + max(right_tuple[0], right_tuple[1])
            return (not_steal, root.val + left_tuple[0] + right_tuple[0])
        result_tuple = rob_house(root)
        return max(result_tuple[0], result_tuple[1])


def main():
    sol = Solution()
    left = TreeNode(2, None, TreeNode(3))
    right = TreeNode(3, None, TreeNode(1))
    root = TreeNode(3, left, right)
    result = sol.rob(root)
    print(result)

if __name__ == "__main__":
    main()