# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        self.count = 0
        def sumNodes(grandParent, parent, node):
            if not node:
                return
            if grandParent and grandParent.val % 2 == 0:
                self.count += node.val
            sumNodes(parent, node, node.left)
            sumNodes(parent, node, node.right)
        sumNodes(None, None, root)
        return self.count

def main():
    left = TreeNode(7, TreeNode(2, TreeNode(9)), TreeNode(7, TreeNode(1), TreeNode(4)))
    right = TreeNode(8,TreeNode(1), TreeNode(3, None, TreeNode(5)))
    root = TreeNode(6, left, right)
    sol = Solution()
    result = sol.sumEvenGrandparent(root)
    print(result)
if __name__ == "__main__":
    main()

