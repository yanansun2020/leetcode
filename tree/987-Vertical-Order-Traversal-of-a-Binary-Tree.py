# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
import collections
from typing import List
from queue import PriorityQueue
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        queue = collections.deque()
        #(node, x position)
        queue.append((root, 0, 0))
        memo = {}
        while queue:
            element = queue.popleft()
            node = element[0]
            x_position = element[1]
            y_position = element[2]
            position_values = memo.get((x_position))
            if not position_values:
                position_values = []
            position_values.append((node.val, y_position))
            memo[(x_position)] = position_values
            left = node.left
            right = node.right
            if left:
                queue.append((left, x_position - 1, y_position -1))
            if right:
                queue.append((right, x_position + 1, y_position-1))
        memo = collections.OrderedDict(sorted(memo.items()))
        result = []
        for k, v in memo.items():
            v.sort(key=lambda tup: (tup[1], -tup[0]), reverse=True)
            tmp = []
            for i in range(len(v)):
                tmp.append(v[i][0])
            result.append(tmp)
        return result
def main():
    sol = Solution()
    # left = TreeNode(9)
    # right = TreeNode(20, TreeNode(15), TreeNode(7))
    # root = TreeNode(3, left, right)
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3, TreeNode(6), TreeNode(7))
    root = TreeNode(1, left, right)
    result = sol.verticalTraversal(root)
    print(result)

if __name__ == "__main__":
    main()