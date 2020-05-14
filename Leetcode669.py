from TreeNode import TreeNode
class Solution:
    def trimBST(self, root: TreeNode, L: int, R: int) -> TreeNode:
        if root is None:
            return None
        sol = Solution()
        if root.val < L:
            root = root.right
            return sol.trimBST(root, L, R)
        if root.val > R:
            root = root.left
            return sol.trimBST(root, L, R)

        root.left = sol.trimBST(root.left, L, R)
        root.right = sol.trimBST(root.right, L, R)
        return root


def main():
    sol = Solution()
    root = TreeNode(1, TreeNode(0, None, None), TreeNode(2, None, None))
    # root = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1, None, None), None)), TreeNode(4, None, None))
    result = sol.trimBST(root, 1, 2)
    print(result)

if __name__ == "__main__":
    main()