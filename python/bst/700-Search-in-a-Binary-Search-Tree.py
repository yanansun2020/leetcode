# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return None
        if root.val == val:
            return root
        if root.val > val:
            return self.searchBST(root.left, val)
        if root.val < val:
            return self.searchBST(root.right, val)


def main():
    sol = Solution()
    # root = TreeNode(236, TreeNode(104, None, TreeNode(227)), TreeNode(701, None, TreeNode(911)))
    root = TreeNode(0, None, TreeNode(2236, TreeNode(1277, TreeNode(519)), TreeNode(2776)))
    result = sol.getMinimumDifference(root)
    print(result)

if __name__ == "__main__":
    main()