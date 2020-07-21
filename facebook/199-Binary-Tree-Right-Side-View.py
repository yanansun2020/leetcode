# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from tree import TreeNode
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        stack, depth = [(root, 0)], 0
        prev_node = root
        while stack:
            node, cur_depth = stack[0][0], stack[0][1]
            if cur_depth != depth:
                result.append(prev_node.val)
                depth = cur_depth
            prev_node = node
            stack.pop(0)
            if node.left:
                stack.append((node.left, cur_depth + 1))
            if node.right:
                stack.append((node.right, cur_depth + 1))
        result.append(prev_node.val)
        return result

