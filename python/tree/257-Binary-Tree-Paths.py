# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        ans = []
        def getPath(node, path):
            if not node:
                ans.append(path[:-2])
                return
            getPath(node.left, path + node.val + "->")
            getPath(node.right, path + node.val + "->")
        getPath(root, "")
        return ans
