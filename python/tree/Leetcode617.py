from TreeNode import TreeNode
class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1 and not t2:
            return None
        if t1 and not t2:
            return t1
        if not t1 and t2:
            return t2
        if t1 and t2:
            t1.val = t1.val + t2.val
            t1.left = self.mergeTrees(t1.left, t2.left)
            t1.right = self.mergeTrees(t1.right, t2.right)
        return t1


def main():
    sol = Solution()
    root1 = TreeNode(3, TreeNode(5, None, None), None)
    root2 = TreeNode(1, None, TreeNode(7, TreeNode(8, None, None), None))
    result = sol.mergeTrees(root1, root2)
    print(result)

if __name__ == "__main__":
    main()