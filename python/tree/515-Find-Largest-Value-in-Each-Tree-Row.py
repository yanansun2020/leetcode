# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import List
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        queue = [(root, 0)]
        depth = 0
        max_value = root.val
        ans = []
        while queue:
            node, cur_depth = queue[0]
            if cur_depth != depth:
                ans.append(max_value)
                max_value = node.val
                depth = cur_depth
            max_value = max(max_value, node.val)
            if node.left:
                queue.append((node.left, cur_depth + 1))
            if node.right:
                queue.append((node.right, cur_depth + 1))
            queue.pop(0)
        ans.append(max_value)
        return ans

def main():
    sol = Solution()
    root = TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(2)), TreeNode(2,None, TreeNode(9)))
    result = sol.largestValues(root)


    print(result)

if __name__ == "__main__":
    main()
