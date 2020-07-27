from TreeNode import TreeNode
class Solution:
    def sumNumbers(self, root):
        if not root: return 0
        if not root.left and not root.right:
            return int(root.val)
        if root.left:
            root.left.val = 10 * root.val + root.left.val
        if root.right:
            root.right.val = 10 * root.val + root.right.val
        leftV = self.sumNumbers(root.left)
        rightV = self.sumNumbers(root.right)
        return leftV + rightV

    def sumNumbers_1(self, root):
        return self.cal(0, root)

    def cal(self, curr, root):
        if not root:
            return 0
        curr = (10*curr) + root.val
        if not root.left and not root.right:
            return curr
        return self.cal(curr, root.left) + self.cal(curr, root.right)

    def suneaves(self, root):
        if not root: return 0
        if not root.left and not root.right:
            return int(root.val)
        # if root.left:
        #     root.left.val = 10*root.val + root.left.val
        # if root.right:
        #     root.right.val = 10*root.val + root.right.val
        leftV = self.sumNumbers(root.left)
        rightV = self.sumNumbers(root.right)
        return leftV + rightV

def main():
    sol = Solution()
    # left = TreeNode(9)
    # right = TreeNode(20, TreeNode(15), TreeNode(7))
    # root = TreeNode(3, left, right)
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3)
    root = TreeNode(1, left, right)
    result = sol.sumNumbers_1(root)
    print(result)

if __name__ == "__main__":
    main()