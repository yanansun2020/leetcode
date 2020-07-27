from TreeNode import TreeNode
class Solution:
    result = 0
    n = 0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.n = k
        self.getDepth(root)
        return self.result

    def getDepth(self, root):
        if not root or self.n <= 0:
            return
        self.getDepth(root.left)
        self.n = self.n -1
        if self.n == 0:
            self.result = root.val
            return
        self.getDepth(root.right)


def main():
    sol = Solution()
    root = TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1, None, None), None), TreeNode(4, None, None)), TreeNode(5, None, None))

    result = sol.kthSmallest(root, 6)
    print(result)

if __name__ == "__main__":
    main()