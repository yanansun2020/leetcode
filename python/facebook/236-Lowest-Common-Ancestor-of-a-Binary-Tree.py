# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left=None, right=None):
        self.val = x
        self.left = left
        self.right = right

class Solution:
    #explain: https://www.youtube.com/watch?v=13m9ZCB8gjw
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        if root.val == p.val or root.val == q.val:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        return left if left is not None else right

def main():
    sol = Solution()
    right = TreeNode(2, TreeNode(7), TreeNode(4))
    root = TreeNode(3,  TreeNode(5, TreeNode(6), right), TreeNode(1, TreeNode(0), TreeNode(8)))
    result = sol.lowestCommonAncestor(root, 5, 1)
    print(result)
    result = sol.lowestCommonAncestor(root, 5, 4)
    print(result)
    result = sol.lowestCommonAncestor(root, 5, 8)
    print(result)
if __name__ == "__main__":
    main()
