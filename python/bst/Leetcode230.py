from TreeNode import TreeNode
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            node = stack.pop()
            k -= 1
            if k ==0:
                return node.val
            root = node.right

    def kthSmallest_dfs(self, root: TreeNode, k: int) -> int:
        self.n = k
        def dfs(node):
            if not node:
                return None
            left = dfs(node.left)
            if left is not None:
                return left
            self.n -= 1
            if self.n == 0:
                return node.val
            right = dfs(node.right)
            return right
        return dfs(root)

def main():
    sol = Solution()
    root = TreeNode(1, None, TreeNode(2))
    result = sol.kthSmallest(root, 2)
    print(result)
    root = TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1, None, None), None), TreeNode(4, None, None)), TreeNode(5, None, None))
    result = sol.kthSmallest(root, 1)
    print(result)

if __name__ == "__main__":
    main()