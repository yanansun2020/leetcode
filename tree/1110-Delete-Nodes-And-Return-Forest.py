# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
from typing import List
class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        self.result = []
        def delete(node, to_delete):
            if not node:
                return None
            node.left = delete(node.left, to_delete)
            node.right = delete(node.right, to_delete)
            if node.val in to_delete:
                if node.left:
                    self.result.append(node.left)
                if node.right:
                    self.result.append(node.right)
                return None
            return node
        node = delete(root, to_delete)
        if node:
            self.result.append(node)
        return self.result
def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3, TreeNode(6), TreeNode(7))
    root = TreeNode(1, left, right)
    result = sol.delNodes(root, [3,5])
    print(1)
if __name__ == "__main__":
    main()
