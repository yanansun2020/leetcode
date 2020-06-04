from TreeNode import TreeNode
class Solution:
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if root is None:
            root = TreeNode(val, None, None)
            return root
        if val>root.val:
            if not root.right:
                root.right = TreeNode(val, None, None)
            else:
                root.right = self.insertIntoBST(root.right, val)
        elif val < root.val:
            if not root.left:
                root.left = TreeNode(val, None, None)
            else:
                root.left = self.insertIntoBST(root.left, val)
        return root

def main():
    # root = TreeNode(4, TreeNode(2, TreeNode(1, None, None), TreeNode(3, None, None)), TreeNode(7, None, None))
    sol = Solution()
    result = sol.insertIntoBST(None, 5)
    print(result)

if __name__ == "__main__":
    main()