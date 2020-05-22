from TreeNode import TreeNode
class Solution:
    def flipEquiv(self, root1: TreeNode, root2: TreeNode) -> bool:
        if not root1 and not root2:
            return True
        if not root1 and root2:
            return False
        if root1 and not root2:
            return False
        if root1.val != root2.val:
             return False
        if root1.val == root2.val:
            root1_left = root1.left
            root2_left = root2.left
            if root1_left and not root2.left or \
                not root1_left and root2_left or\
                   root1_left and root2_left and root1_left.val != root2_left.val:
                    tmp = root1.left
                    root1.left = root1.right
                    root1.right = tmp
            leftEq = self.flipEquiv(root1.left, root2.left)
            rightEq = self.flipEquiv(root1.right, root2.right)
            return leftEq and rightEq

def main():
    sol = Solution()
    left_1 = TreeNode(2, TreeNode(4, None, None), TreeNode(5, TreeNode(7, None, None), TreeNode(8, None, None)))
    root = TreeNode(1, left_1,  TreeNode(3, TreeNode(6, None, None), None))

    right_1 = TreeNode(2, TreeNode(4, None, None), TreeNode(5, TreeNode(10, None, None), TreeNode(7, None, None)))
    root_2 = TreeNode(1, TreeNode(3, None, TreeNode(6, None, None)), right_1)
    result = sol.flipEquiv(root, root_2)
    print(result)

if __name__ == "__main__":
    main()
