from TreeNode import TreeNode
class Solution:
    def countNodes(self, root: TreeNode) -> int:
        # self.num = 0
        # def count(node):
        #     if not node:
        #         return
        #     self.num += 1
        #     count(node.left)
        #     count(node.right)
        # count(root)
        self.depth = 0
        def getHeight(node):
            if not node:
                return
            self.depth += 1
            getHeight(node.left)
        return self.num
def main():
    sol = Solution()
    # left = TreeNode(9)
    # right = TreeNode(20, TreeNode(15), TreeNode(7))
    # root = TreeNode(3, left, right)
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3, TreeNode(6))
    root = TreeNode(1, left, right)
    result = sol.countNodes(root)
    print(result)

if __name__ == "__main__":
    main()