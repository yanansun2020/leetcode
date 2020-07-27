# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# width = nodes.length
from TreeNode import TreeNode
class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        nodes = [(root, 1)]
        i = 0
        while i < len(nodes):
            node, v = nodes[i]
            i += 1
            if node:
                nodes.append((node.left, 2*v))
                nodes.append((node.right, 2*v+1))

        return  nodes[-1][1] == len(nodes)
def main():
    sol = Solution()
    # left = TreeNode(2, TreeNode(4), TreeNode(5))
    # right = TreeNode(3,None, TreeNode(7))
    # root = TreeNode(1, left, right)
    root = TreeNode(1, TreeNode(2))
    result = sol.isCompleteTree(root)
    print(result)
if __name__ == "__main__":
    main()
