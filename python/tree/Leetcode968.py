from TreeNode import TreeNode

class Solution:
    result = 0
    def minCameraCover(self, root: TreeNode) -> int:
        if not root.left and not root.right:
            return 1
        self.traversal(root)
        return self.result

    def traversal(self, node):
        if not node:
            return 0
        if not node.left and not node.right:
            return -1
        left_val = self.traversal(node.left)
        right_val = self.traversal(node.right)
        sum_val = left_val + right_val
        if sum_val == -2 or sum_val == -1 or sum_val == 0:
            node.val = 1
            self.result = self.result + 1
        return node.val

def main():
    sol = Solution()
    root = TreeNode(0, TreeNode(0, TreeNode(0, None, None), TreeNode(0, None, None)), None)
    result = sol.minCameraCover(root)
    print(result)
    root = TreeNode(0, None, None)
    result = sol.minCameraCover(root)
    print(result)
    root = TreeNode(0, None, TreeNode(0, None, None))
    result = sol.minCameraCover(root)
    print(result)

if __name__ == "__main__":
    main()